package com.nan.netty.study.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.marshalling.MarshallingDecoder;
import io.netty.handler.codec.marshalling.UnmarshallerProvider;


public class NettyMarshallingDecoder extends MarshallingDecoder{
	
	 
	public NettyMarshallingDecoder(UnmarshallerProvider provider) {
		super(provider);
	}

	public NettyMarshallingDecoder(UnmarshallerProvider provider, int maxObjectSize){
		super(provider, maxObjectSize);
	}
	
	public Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
//		int objectSize = in.readInt();
//		Unmarshaller unmarshaller = provider.getUnmarshaller(ctx);
//		ByteBuf buf = in.slice(in.readerIndex(), objectSize);
//        ByteInput input = new ChannelBufferByteInput(buf);
//
//        try {
//            unmarshaller.start(input);
//            Object obj = unmarshaller.readObject();
//            unmarshaller.finish();
//            return obj;
//        } finally {
//            // Call close in a finally block as the ReplayingDecoder will throw an Error if not enough bytes are
//            // readable. This helps to be sure that we do not leak resource
//            unmarshaller.close();
//        }
		return super.decode(ctx, in);
	}
}
