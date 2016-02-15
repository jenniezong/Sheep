package com.nan.netty.publish;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleStateHandler;

public class HeartHandler extends IdleStateHandler{

	public HeartHandler(int readerIdleTimeSeconds, int writerIdleTimeSeconds,
			int allIdleTimeSeconds) {
		super(readerIdleTimeSeconds, writerIdleTimeSeconds, allIdleTimeSeconds);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		ctx.pipeline().addLast(this);
//		ctx.fireChannelRegistered();
	}
	
	

}
