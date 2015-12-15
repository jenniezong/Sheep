package com.nan.netty.study.protocol;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.nan.netty.study.common.StockRealtime;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class LoginAuthRespHandler extends ChannelHandlerAdapter {
	
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		NettyMessage message = (NettyMessage) msg;
		if (message.getHeader() != null
				&& message.getHeader().getType() == MessageType.LOGREQ.value()) {
			System.out.println("Login is OK");
//			}
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

	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}

	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		ctx.close();
	}
}
