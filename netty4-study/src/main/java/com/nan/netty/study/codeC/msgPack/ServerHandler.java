package com.nan.netty.study.codeC.msgPack;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ServerHandler extends ChannelInboundHandlerAdapter{
	
	

	
	@Override
	public void channelRead(ChannelHandlerContext ctx ,Object msg)
			throws Exception {
//		List<StockRealtime> list = (List<StockRealtime>) msg;
//		for (StockRealtime stockRealtime : list) {
			System.out.println("Server recieved the msg : " /*+ JSON.toJSONString(stockRealtime)*/);
//		}
	}

	
}
