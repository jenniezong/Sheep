package com.nan.netty.study.codeC.msgPack;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;

public class Server {
	public void run(int port) {
		EventLoopGroup acceptorGroup = new NioEventLoopGroup();
		EventLoopGroup IOGroup = new NioEventLoopGroup();

		ServerBootstrap b = new ServerBootstrap();
		b.group(acceptorGroup, IOGroup).channel(NioServerSocketChannel.class)
				.option(ChannelOption.SO_BACKLOG, 100)
				.handler(new ServerHandler())
				.childHandler(new ChannelInitializer<SocketChannel>() {

					@Override
					protected void initChannel(SocketChannel ch)
							throws Exception {

						ch.pipeline().addLast(
								"frameDecoder",
								new LengthFieldBasedFrameDecoder(
										5 * 1024 * 1024, 0, 4, 0, 4));
						ch.pipeline().addLast("msgPack decoder",
								new MsgPackDecoder());
						ch.pipeline().addLast("frameEncoder",
								new LengthFieldPrepender(4));
						ch.pipeline().addLast("msgPack encoder",
								new MsgPackEncoder());
						ch.pipeline().addLast(new ServerHandler());
					}
				});

		try {
			ChannelFuture f = b.bind(port).sync();
			System.out.println("Server started at port " + port);
			f.channel().closeFuture().sync();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			new Server().run(12345);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
}
