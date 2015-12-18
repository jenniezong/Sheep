package com.nan.netty.study.codeC.msgPack;

import java.util.List;
import org.msgpack.MessagePack;
import com.nan.netty.study.common.StockRealtime;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

public class MsgPackDecoder extends MessageToMessageDecoder<ByteBuf>{

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf msg,
			List<Object> out) throws Exception {
		final byte[] array;
		final int length = msg.readableBytes();
		array = new byte[length];
		msg.getBytes(msg.readerIndex(), array, 0, length);
		MessagePack msgPack = new MessagePack();
		StockRealtime s =  msgPack.read(array, StockRealtime.class);
		out.add(s);
	}

}
