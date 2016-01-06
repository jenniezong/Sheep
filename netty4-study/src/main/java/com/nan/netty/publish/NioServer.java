package com.nan.netty.publish;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

public class NioServer {

	public static void main(String[] args) {
		EventLoopGroup bossGroup = new NioEventLoopGroup(1);
		EventLoopGroup workerGroup = new NioEventLoopGroup(10);
		try {
			ServerBootstrap boot = new ServerBootstrap();
			boot.group(bossGroup, workerGroup)
					.channel(NioServerSocketChannel.class)
					.childHandler(new ChannelInitializer<SocketChannel>() {

						@Override
						protected void initChannel(SocketChannel ch)
								throws Exception {
							ch.pipeline()
									.addLast(new LineBasedFrameDecoder(1000))
									.addLast(
											new StringDecoder(CharsetUtil.UTF_8))
									.addLast(
											new StringEncoder(CharsetUtil.UTF_8))
									.addLast(new LinkbuildHandler());

						}
					});
			ChannelFuture f = boot.bind(12345).sync();
			f.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}

	}
}
