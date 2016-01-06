package com.nan.netty.publish;

import java.net.InetAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

public class NioClient {

	private static final Logger log = LoggerFactory.getLogger(NioClient.class);
	
	private void connect(String ip, int port) throws Exception {
		EventLoopGroup workerGroup = new NioEventLoopGroup(10);

		try {
			Bootstrap b = new Bootstrap();
			b.group(workerGroup).channel(NioSocketChannel.class)
					.handler(new ChildChannelHandler());
			ChannelFuture future = b.connect(ip, port).sync();
			future.channel().closeFuture().sync();
		} finally {
			workerGroup.shutdownGracefully();
		}
	}

	private static class ChildChannelHandler extends
			ChannelInitializer<SocketChannel> {

		@Override
		protected void initChannel(SocketChannel ch) throws Exception {
			ch.pipeline().addLast(new StringDecoder(CharsetUtil.UTF_8))
					.addLast(new StringEncoder(CharsetUtil.UTF_8))
					.addLast(new LoginReqHandler());
		}

	}

	public static void main(String[] args) {

		try {
			new NioClient().connect(InetAddress.getLocalHost().getHostAddress(), 12345);
		} catch (Exception e) {
			log.error("client connect error!", e);
		}
	}
}
