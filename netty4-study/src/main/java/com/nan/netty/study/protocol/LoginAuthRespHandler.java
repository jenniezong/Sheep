package com.nan.netty.study.protocol;

import java.util.concurrent.TimeUnit;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class LoginAuthRespHandler extends ChannelInboundHandlerAdapter {
	
	private static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("Server active" + ctx.channel().remoteAddress());
		ctx.fireChannelActive();
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		NettyMessage message = (NettyMessage) msg;
		if (message.getHeader() != null
				&& message.getHeader().getType() == MessageType.LOGREQ.value()) {
			System.out.println("Login is OK");
//			}
			channels.add(ctx.channel());
//			ctx.executor().scheduleAtFixedRate(new PubMsgTask(ctx), 0, 5000, TimeUnit.MILLISECONDS);
			ctx.writeAndFlush(buildLoginResponse("Received the login message!"));
		}else {
			ctx.fireChannelRead(msg);
		}
	}

	private NettyMessage buildLoginResponse(String result) {
		NettyMessage message = new NettyMessage();
		Header header = new Header();
		header.setType(MessageType.LOGRESP.value());
		message.setHeader(header);
		message.setBody(result);
		return message;
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		ctx.close();
	}
	
	private class PubMsgTask implements Runnable {

		private final ChannelHandlerContext context;
		
		public PubMsgTask(ChannelHandlerContext context) {
			this.context = context;
		}
		
		public void run() {
			
			NettyMessage message = new NettyMessage();
			Header header = new Header();
			header.setType(MessageType.PUBLISH.value());
			message.setHeader(header);
			message.setBody("Send message to all client!");
			channels.writeAndFlush(message);
			
		}
		
	}
}
