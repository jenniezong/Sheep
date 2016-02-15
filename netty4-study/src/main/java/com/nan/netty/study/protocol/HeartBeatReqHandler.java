package com.nan.netty.study.protocol;

import java.util.concurrent.TimeUnit;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.concurrent.ScheduledFuture;

public class HeartBeatReqHandler extends ChannelInboundHandlerAdapter{
	
	private volatile ScheduledFuture<?> heartBeatFuture;

	
	
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("heart beat actived!");
		
	};
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
//		super.channelRead(ctx, msg);
		NettyMessage message = (NettyMessage) msg;
		if(message.getHeader() != null && message.getHeader().getType() == MessageType.LOGRESP.value()) {
			heartBeatFuture = ctx.executor().scheduleAtFixedRate(new HeartBeatTask(ctx), 0, 5000, TimeUnit.MILLISECONDS);
			ctx.fireChannelRead(msg);
		}else if (message.getHeader() != null && message.getHeader().getType() == MessageType.HEARTRESP.value()) {
			System.out.println("Client receive server heart beat message : ----> " + message);
		}else {
			ctx.fireChannelRead(msg);
		}
	}
	
	
	
	private class HeartBeatTask implements Runnable {

		private final ChannelHandlerContext context;
		
		public HeartBeatTask(final ChannelHandlerContext context) {
			this.context = context;
		}
		
		public void run() {
			NettyMessage heartBeat = buildHeartBeat();
			System.out.println("Client send heart beat message to server : ---->" + heartBeat); 
			context.writeAndFlush(heartBeat);
			
		}
		
		private NettyMessage buildHeartBeat() {
			NettyMessage message = new NettyMessage();
			Header header = new Header();
			header.setType(MessageType.HEARTREQ.value());
			message.setHeader(header);
			return message;
		}
		
	}

}
