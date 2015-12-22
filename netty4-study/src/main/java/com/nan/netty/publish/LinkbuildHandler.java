package com.nan.netty.publish;

import java.util.concurrent.TimeUnit;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class LinkbuildHandler extends ChannelInboundHandlerAdapter{

	private static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println(ctx.channel().remoteAddress());
		channels.add(ctx.channel());
		ctx.executor().scheduleAtFixedRate(new PubMsgTask(ctx), 0, 5000, TimeUnit.MILLISECONDS);
	}
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		channels.writeAndFlush(msg);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		// TODO Auto-generated method stub
		super.exceptionCaught(ctx, cause);
	}

	private class PubMsgTask implements Runnable {

		private final ChannelHandlerContext context;
		
		public PubMsgTask(ChannelHandlerContext context) {
			this.context = context;
		}
		
		public void run() {
			channels.writeAndFlush("Send message to all client!");
			
		}
		
	}
}
