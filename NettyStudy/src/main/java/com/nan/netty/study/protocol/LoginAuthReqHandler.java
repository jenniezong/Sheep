package com.nan.netty.study.protocol;

import java.io.File;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.nan.netty.study.common.Mktdt00TXT;
import com.nan.netty.study.common.StockRealtime;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class LoginAuthReqHandler extends ChannelHandlerAdapter {
	
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("LoginAuthReqHandler->channelActive");
		ctx.writeAndFlush(buildLoginReq());
	}

	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		System.out.println("LoginAuthReqHandler->channelRead");
		NettyMessage message = (NettyMessage) msg;
		if (message.getHeader() != null
				&& message.getHeader().getType() == (byte) 2) {
			System.out.println("Received from server response");
		}
		ctx.fireChannelRead(msg);
	}

	private NettyMessage buildLoginReq() {
		NettyMessage message = new NettyMessage();
		Header header = new Header();
		header.setType((byte) 1);
		message.setHeader(header);
		Object[] objs = Mktdt00TXT.readTxtFile(new File("g:\\mktdt00.txt"));
		List<StockRealtime> list = (List<StockRealtime>) objs[0];
		System.out.println("size : "+list.size());
		String body = JSON.toJSONString(list);
		message.setBody(body);
//		message.setBody("It is a request");
		return message;
	}

	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}

	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		ctx.close();
	}
}
