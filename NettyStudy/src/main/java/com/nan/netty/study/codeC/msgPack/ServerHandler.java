package com.nan.netty.study.codeC.msgPack;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.nan.netty.study.common.StockRealtime;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class ServerHandler extends ChannelHandlerAdapter{

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
//		List<StockRealtime> list = (List<StockRealtime>) msg;
//		for (StockRealtime stockRealtime : list) {
			System.out.println("Server recieved the msg : " /*+ JSON.toJSONString(stockRealtime)*/);
//		}
	}

	
}
