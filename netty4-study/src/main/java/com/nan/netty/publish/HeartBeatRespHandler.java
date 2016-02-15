package com.nan.netty.publish;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class HeartBeatRespHandler extends ChannelInboundHandlerAdapter{

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
//		super.channelRead(ctx, msg);
//		NettyMessage message = (NettyMessage) msg;
//		
//		if(message.getHeader() != null && message.getHeader().getType() == MessageType.HEARTREQ.value()) {
//			System.out.println("Recieve client heart beat message : ----> " + message);
//			NettyMessage heartBeat = buildHeartBeat();
//			System.out.println("Send heart beat response message to client : ---> " + heartBeat);
//			ctx.writeAndFlush(heartBeat);
//		}else {
//			ctx.fireChannelRead(msg);
//		}
		
		ctx.writeAndFlush("Heart response message");
		
	}
	
	
}
