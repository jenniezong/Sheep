package com.nan.netty.study.protocol;

import java.util.List;

import java.util.Map;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

public final class NettyMessageEncoder extends MessageToMessageEncoder<NettyMessage>{
	
	NettyMarshallingEncoder marshallingEncoder;

	public NettyMessageEncoder() {
		
		this.marshallingEncoder = MarshallingCodeCFactory.buildMarshallingEncoder();
	}
	@Override
	protected void encode(ChannelHandlerContext ctx, NettyMessage msg,
			List<Object> out) throws Exception {
		ByteBuf sendBuf = Unpooled.buffer();
		sendBuf.writeInt(msg.getHeader().getCrcCode());
		sendBuf.writeInt(msg.getHeader().getLength());
		sendBuf.writeLong(msg.getHeader().getSessionID());
		sendBuf.writeByte(msg.getHeader().getType());
		sendBuf.writeByte(msg.getHeader().getPriority());
		sendBuf.writeByte(msg.getHeader().getAttachment().size());
		String key = null;
		byte[] keyArray = null;
		Object value = null;
		for (Map.Entry<String,Object> param : msg.getHeader().getAttachment().entrySet()) {
			key = param.getKey();
			keyArray = key.getBytes("UTF-8");
			sendBuf.writeInt(keyArray.length);
			sendBuf.writeBytes(keyArray);
			value = param.getValue();
			marshallingEncoder.encode(ctx, value, sendBuf);
		}
		key = null;
		keyArray = null;
		value = null;
		int bodyIdx = 0;
		if(msg.getBody() != null){
			bodyIdx = sendBuf.readableBytes();
			marshallingEncoder.encode(ctx, msg.getBody(), sendBuf);
		}
			
		// sendBuf.writeInt(0);
		// 在第4个字节出写入Buffer的长度
		int readableBytes = sendBuf.readableBytes();
		sendBuf.setInt(4, readableBytes);
		sendBuf.setInt(bodyIdx,readableBytes-bodyIdx);

		// 把Message添加到List传递到下一个Handler

		out.add(sendBuf);
	}

}
