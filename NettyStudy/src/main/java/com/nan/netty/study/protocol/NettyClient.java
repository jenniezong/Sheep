package com.nan.netty.study.protocol;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClient {

	public void connect(String remoteServer, int port) throws Exception {
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			Bootstrap b = new Bootstrap();
			b.group(workerGroup)
					.channel(NioSocketChannel.class)
					.handler(new ChildChannelHandler());
			
			ChannelFuture f = b.connect(remoteServer,port).sync();
			System.out.println("Netty time Client connected at port " + port);
			f.channel().closeFuture().sync();
		} finally {
			workerGroup.shutdownGracefully();
		}
	}

	public static class ChildChannelHandler extends
			ChannelInitializer<SocketChannel> {

		@Override
		protected void initChannel(SocketChannel ch) throws Exception {
			
			ch.pipeline().addLast(new NettyMessageDecoder(6*1024*1024, 4, 4, -8, 0))
			.addLast(new NettyMessageEncoder())
			.addLast(new LoginAuthReqHandler())
//			.addLast(new HeartBeatReqHandler())
			.addLast(new ReqMsgHandler());
		}

	}
	
	public static void main(String[] args){
		try {
			new NettyClient().connect("10.13.24.49", 12345);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
}
