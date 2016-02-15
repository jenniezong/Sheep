package com.nan.netty.study.protocol;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class PublishRepHandler extends ChannelInboundHandlerAdapter{

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		NettyMessage message = (NettyMessage) msg;
		if (message.getHeader() != null
				&& message.getHeader().getType() == MessageType.PUBLISH.value()) {
			System.out.println("Received publish msg from server" + message);
		}
//		ctx.fireChannelRead(msg);
	}

	
}
