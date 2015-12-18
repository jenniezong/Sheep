package com.nan.netty.study.codeC.msgPack;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import com.alibaba.fastjson.JSON;

public class ServerHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
//		List<Object> list = (List<Object>) msg;
//		for (Object obj : list) {

//			StockRealtime stockRealtime = (StockRealtime) msg;
			System.out.println("Server recieved the msg : "
					+ JSON.toJSONString(msg));
//		}
	}

}
