package com.nan.netty.study.protocol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class HeartBeatRespHandler extends ChannelInboundHandlerAdapter{

	private static final Logger log = LoggerFactory.getLogger(HeartBeatRespHandler.class);
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
//		super.channelRead(ctx, msg);
		NettyMessage message = (NettyMessage) msg;
		
		if(message.getHeader() != null && message.getHeader().getType() == MessageType.HEARTREQ.value()) {
			log.info("Recieve client heart beat message : ----> " + message);
			NettyMessage heartBeat = buildHeartBeat();
			log.info("Send heart beat response message to client : ---> " + heartBeat);
			ctx.writeAndFlush(heartBeat);
		}else {
			ctx.fireChannelRead(msg);
		}
		
		
	}
	
	private NettyMessage buildHeartBeat() {
		NettyMessage message = new NettyMessage();
		Header header = new Header();
		header.setType(MessageType.HEARTRESP.value());
		message.setHeader(header);
		return message;
	}
	
	
}
