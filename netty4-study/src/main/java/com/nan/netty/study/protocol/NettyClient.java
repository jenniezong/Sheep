package com.nan.netty.study.protocol;

import java.net.InetAddress;
import java.util.concurrent.TimeUnit;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

public class NettyClient {

	public void connect(String remoteServer, int port) throws Exception {
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			Bootstrap b = new Bootstrap();
			b.group(workerGroup)
					.channel(NioSocketChannel.class)
//					.handler(new ReadTimeoutHandler(5))
					.handler(new ChildChannelHandler());
			
			ChannelFuture f = b.connect(remoteServer,port).sync();
			f.addListener(new GenericFutureListener<Future<? super Void>>() {

				public void operationComplete(Future<? super Void> future)
						throws Exception {
					
					
				}
			});
			System.out.println("Netty time Client connected at port " + port);
			f.channel().closeFuture().sync();
		} finally {
			workerGroup.shutdownGracefully();
			workerGroup.execute(new Runnable() {
				
				public void run() {

					System.out.println("closed");
				}
			});
		}
	}

	public static class ChildChannelHandler extends
			ChannelInitializer<SocketChannel> {

		@Override
		protected void initChannel(SocketChannel ch) throws Exception {
			
			ch.pipeline().addLast(new NettyMessageDecoder(6*1024*1024, 4, 4, -8, 0))
			.addLast(new NettyMessageEncoder())
			.addLast(new LoginAuthReqHandler())
//			.addLast(new ReadTimeoutHandler(1000, TimeUnit.MILLISECONDS))
//			.addLast(new IdleHandler(5000, 5000, 5000, TimeUnit.MILLISECONDS))
			.addLast(new HeartBeatReqHandler())
			.addLast(new ReqMsgHandler())
			.addLast(new PublishRepHandler()
			);
		}

	}
	
	public static void main(String[] args){
		try {
			new NettyClient().connect(InetAddress.getLocalHost().getHostAddress(), 12345);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
}
