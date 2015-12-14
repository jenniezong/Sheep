package com.nan.netty.study.codeC.msgPack;

import java.io.File;
import java.util.List;

import com.nan.netty.study.common.Mktdt00TXT;
import com.nan.netty.study.common.StockRealtime;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class ClientHandler extends ChannelHandlerAdapter{

	private int sendNumber;
	
	public ClientHandler() {
//		this.sendNumber = sendNumber;
	}
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		Object[] objs = Mktdt00TXT.readTxtFile(new File("g:\\mktdt00.txt"));
		List<StockRealtime> list = (List<StockRealtime>) objs[0];
//		for (StockRealtime stockRealtime : list) {
//			ctx.write(stockRealtime);
//		}
//		
//		ctx.flush();
		
		ctx.writeAndFlush(list.get(0));
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		System.out.println("Client receive the msgpack message : " + msg);
		ctx.write(msg);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}

	
}
