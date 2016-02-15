package com.nan.netty.study.protocol;

import java.util.concurrent.TimeUnit;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;

public class IdleHandler extends  IdleStateHandler{

	public IdleHandler(long readerIdleTime, long writerIdleTime,
			long allIdleTime, TimeUnit unit) {
		super(readerIdleTime, writerIdleTime, allIdleTime, unit);
	}

	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
//		ctx.pipeline().addLast(new HeartBeatReqHandler());
//		ctx.fireChannelRegistered();
		super.handlerAdded(ctx);
	}

	@Override
	protected void channelIdle(ChannelHandlerContext ctx, IdleStateEvent evt)
			throws Exception {
		// TODO Auto-generated method stub
//		ctx.pipeline().addLast(new HeartBeatReqHandler());
		ctx.writeAndFlush(buildHeartBeat());
	}
	
	
	private NettyMessage buildHeartBeat() {
		NettyMessage message = new NettyMessage();
		Header header = new Header();
		header.setType(MessageType.HEARTREQ.value());
		message.setHeader(header);
		return message;
	}
	
	
}
