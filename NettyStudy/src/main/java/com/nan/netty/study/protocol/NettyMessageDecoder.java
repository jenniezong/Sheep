package com.nan.netty.study.protocol;

import io.netty.buffer.ByteBuf;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

import java.util.HashMap;
import java.util.Map;

import org.jboss.marshalling.Marshaller;
import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.Marshalling;
import org.jboss.marshalling.serial.SerialMarshallerFactory;

public class NettyMessageDecoder extends LengthFieldBasedFrameDecoder {
	private NettyMarshallingDecoder marshallingDecoder;

	public NettyMessageDecoder(int maxFrameLength, int lengthFieldOffset,
			int lengthFieldLength, int lengthAdjustment, int initialBytesToStrip) {
		super(maxFrameLength, lengthFieldOffset, lengthFieldLength,
				lengthAdjustment, initialBytesToStrip);
		marshallingDecoder = MarshallingCodeCFactory.buildMarshallingDecoder();
	}

	public Object decode(ChannelHandlerContext ctx, ByteBuf in)
			throws Exception {
		ByteBuf frame = (ByteBuf) super.decode(ctx, in);
//		System.out.println(new String(frame.array(),"UTF-8"));
		if (frame == null) {
			return null;
		}
//		ByteBuf frame = in;
		NettyMessage message = new NettyMessage();
		Header header = new Header();
		header.setCrcCode(frame.readInt());
		header.setLength(frame.readInt());
		header.setSessionID(frame.readLong());
		header.setType(frame.readByte());
		header.setPriority(frame.readByte());
		byte size = frame.readByte();
		
		if (size > 0) {
			Map<String, Object> attach = new HashMap<String, Object>(size);
			int keySize = 0;
			byte[] keyArray = null;
			String key = null;
			for (int i = 0; i < size; i++) {
				keySize = frame.readInt();
				keyArray = new byte[keySize];
				frame.readBytes(keyArray);
				key = new String(keyArray, "UTF-8");
				attach.put(key, marshallingDecoder.decode(ctx, frame));
			}
			key = null;
			keyArray = null;
			header.setAttachment(attach);
		}
		if (frame.readableBytes() > 0) {
//			byte[] dst = new byte[frame.readableBytes()];
//			frame.readBytes(dst);
			int bodyLen = frame.readInt();
			byte[] bs = new byte[bodyLen];
			message.setBody(new String(frame.readBytes(bodyLen).array(), "UTF-8"));
//			message.setBody(marshallingDecoder.decode(ctx, frame));
//			marshaller.writeObject(obj);
//			marshalling.get
		}
		message.setHeader(header);
		return message;
	}
}
