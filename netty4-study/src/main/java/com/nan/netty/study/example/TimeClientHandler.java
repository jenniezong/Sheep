package com.nan.netty.study.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TimeClientHandler extends ChannelInboundHandlerAdapter{

	private static final Logger logger = LoggerFactory.getLogger(TimeClientHandler.class.getName());
//	private final ByteBuf firstMessage;
	
	private int counter;
	
	private byte[] req;
	
	
	public TimeClientHandler() {
		req = ("QUERY TIME ORDER" + System.getProperty("line.separator")).getBytes();
//		firstMessage = 	Unpooled.buffer(req.length);
//		System.out.println("message length : " + req.length);
//		firstMessage.writeBytes(req);
	}
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		logger.warn("Unexpected exception from downstream : " + cause.getMessage());
		ctx.close();
	}
	

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		ByteBuf message = null;
		for (int i = 0; i < 100 ; i++) {
			message = Unpooled.buffer(req.length);
			message.writeBytes(req);
			ctx.writeAndFlush(message);
		}
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
//		ByteBuf buf = (ByteBuf) msg;
//		byte[]	req = new byte[buf.readableBytes()];
//		buf.readBytes(req);
//		String body = new String(req,"UTF-8");
		String body = (String) msg;
		System.out.println("Now is : " + body + " ; the counter is : " + ++counter );
	}

	
}