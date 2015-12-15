package com.nan.netty.study.protocol;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class LoginAuthReqHandler extends ChannelHandlerAdapter {
	
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
//		System.out.println("LoginAuthReqHandler->channelActive");
		ctx.writeAndFlush(buildLoginReq());
	}

	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
//		System.out.println("LoginAuthReqHandler->channelRead");
		NettyMessage message = (NettyMessage) msg;
		if (message.getHeader() != null
				&& message.getHeader().getType() == MessageType.LOGRESP.value()) {
			System.out.println("Received from server response");
		}
		ctx.fireChannelRead(msg);
	}

	private NettyMessage buildLoginReq() {
		NettyMessage message = new NettyMessage();
		Header header = new Header();
		header.setType(MessageType.LOGREQ.value());
		message.setHeader(header);
		message.setBody("It is a request");
		return message;
	}

	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}

	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		ctx.close();
	}
}
