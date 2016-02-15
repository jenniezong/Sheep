package com.nan.netty.study.protocol;

import java.io.File;
import java.util.Collections;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.nan.netty.study.common.Mktdt00TXT;
import com.nan.netty.study.common.StockRealtime;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

public class ReqMsgHandler extends ChannelInboundHandlerAdapter {

	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		NettyMessage message = (NettyMessage) msg;
		if (message.getHeader() != null
				&& message.getHeader().getType() == MessageType.LOGRESP.value()) {
			ctx.writeAndFlush(buildStockReq());

		}else if (message.getHeader() != null
				&& message.getHeader().getType() == MessageType.RESPONSE.value()) {
			System.out.println("ReqMsgHandler->write() response time :" + System.currentTimeMillis());
		} else {
			ctx.fireChannelRead(msg);
		}
	}

	private NettyMessage buildStockReq() {
		NettyMessage message = new NettyMessage();
		Header header = new Header();
		header.setType(MessageType.REQUEST.value());
		message.setHeader(header);
		
		List<StockRealtime> list = Lists.newLinkedList();
		
		for (int i =0; i < 1;i++) {
			Object[] objs = Mktdt00TXT.readTxtFile(new File("g:\\mktdt00.txt"));
			list.addAll((List<StockRealtime>) objs[0]);
		}
		System.out.println("size : " + list.size());
		String body = JSON.toJSONString(list);
		message.setBody(body);
		System.out.println("ReqMsgHandler->write() request time :" + System.currentTimeMillis());
		return message;
	}
}
