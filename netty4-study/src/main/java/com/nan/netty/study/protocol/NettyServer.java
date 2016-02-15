package com.nan.netty.study.protocol;


import com.nan.netty.publish.LinkbuildHandler;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

public class NettyServer {
	
	public void bind(int port) throws Exception {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup)
					.channel(NioServerSocketChannel.class)
					.option(ChannelOption.SO_BACKLOG, 1024)
					.handler(new ChannelHandler())
					.childHandler(new ChildChannelHandler());

			ChannelFuture f = b.bind(port).sync();
			System.out.println("Netty time Server started at port " + port);
			f.channel().closeFuture().sync();
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}

	public static class ChildChannelHandler extends
			ChannelInitializer<SocketChannel> {

		@Override
		protected void initChannel(SocketChannel ch) throws Exception {
			ch.pipeline()
					.addLast(new NettyMessageDecoder(6*1024*1024, 4, 4, -8, 0))
					.addLast(new NettyMessageEncoder())
					.addLast(new LoginAuthRespHandler())
//					.addLast(new ReadTimeoutHandler(1000, TimeUnit.MILLISECONDS))
					.addLast(new HeartBeatRespHandler())
					.addLast(new RespMsgHandler());
		}

	}
	
	public static class ChannelHandler extends ChannelInitializer<NioServerSocketChannel> {

		/* (non-Javadoc)
		 * @see io.netty.channel.ChannelInitializer#initChannel(io.netty.channel.Channel)
		 */
		@Override
		protected void initChannel(NioServerSocketChannel ch) throws Exception {

			ch.pipeline()
			.addLast(new LineBasedFrameDecoder(1000))
			.addLast(
					new StringDecoder(CharsetUtil.UTF_8))
			.addLast(
					new StringEncoder(CharsetUtil.UTF_8))
			.addLast(new LinkbuildHandler());
		}
		
	}

	public static void main(String[] args) {
		try {
			new NettyServer().bind(12345);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
}
