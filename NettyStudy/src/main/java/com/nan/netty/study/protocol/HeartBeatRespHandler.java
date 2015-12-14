package com.nan.netty.study.protocol;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class HeartBeatRespHandler extends ChannelHandlerAdapter{

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
//		super.channelRead(ctx, msg);
		NettyMessage message = (NettyMessage) msg;
		
		if(message.getHeader() != null && message.getHeader().getType() == 0) {
			System.out.println("Recieve client heart beat message : ----> " + message);
			NettyMessage heartBeat = buildHeartBeat();
			System.out.println("Send heart beat response message to client : ---> " + heartBeat);
			ctx.writeAndFlush(heartBeat);
		}else {
			ctx.fireChannelRead(msg);
		}
		
		
	}
	
	private NettyMessage buildHeartBeat() {
		NettyMessage message = new NettyMessage();
		Header header = new Header();
		header.setType((byte)1);
		message.setHeader(header);
		return message;
	}
	
	
}
