package com.nan.netty.study.codeC.msgPack;

import java.net.InetAddress;
import java.net.UnknownHostException;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;

public class Client {

	private String host;
	private int port;

	public Client(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public void run() {
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			Bootstrap b = new Bootstrap();
			b.group(group).channel(NioSocketChannel.class)
					.option(ChannelOption.TCP_NODELAY, true)
					.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 3000)
					.handler(new ChannelInitializer<SocketChannel>() {

						@Override
						public void initChannel(SocketChannel ch)
								throws Exception {
							ch.pipeline().addLast(
									"frameDecoder",
									new LengthFieldBasedFrameDecoder(
											5 * 1024 * 1024, 0, 4, 0, 4));
							ch.pipeline().addLast("msgpackDecoder",
									new MsgPackDecoder());
							ch.pipeline().addLast("frameEncoder",
									new LengthFieldPrepender(4));
							ch.pipeline().addLast("msgpackEncoder",
									new MsgPackEncoder());
							ch.pipeline().addLast(new ClientHandler());
						}
					});

			ChannelFuture f = b.connect(host, port).sync();
			System.out.println("Netty time Client connected at port " + port);
			f.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	public static void main(String[] args) {
		Client client;
		try {
			client = new Client(InetAddress.getLocalHost().getHostAddress(), 12345);
			client.run();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// new Client("10.13.24.31", 12345);
	}
}
