package com.nan.netty.study.protocol;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.nan.netty.study.common.StockRealtime;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class RespMsgHandler extends ChannelHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

		NettyMessage message = (NettyMessage)msg;
		if (message.getHeader() != null
				&& message.getHeader().getType() == MessageType.REQUEST.value()) {
			System.out.println("RespMsgHandler ->channelRead, Time is " + System.currentTimeMillis());
			ctx.writeAndFlush(buildRespMsg());
			String body = (String) message.getBody();
//			System.out.println("Recevied message body from client is " + body);
			List<StockRealtime> list = JSON.parseArray(body,
					StockRealtime.class);
			for (StockRealtime stockRealtime : list) {
				String s = JSON.toJSONString(stockRealtime);
//				System.out.println("Recevied message body from client is " + s);
			}
		}

	}
	
	private NettyMessage buildRespMsg() {
		NettyMessage message = new NettyMessage();
		Header header = new Header();
		header.setType(MessageType.RESPONSE.value());
		message.setHeader(header);
		message.setBody("Reviced the stock message!");
		return message;
	}

}
