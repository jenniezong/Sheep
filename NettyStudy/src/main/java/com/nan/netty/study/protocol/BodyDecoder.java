package com.nan.netty.study.protocol;


import io.netty.buffer.ByteBuf;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

public abstract class BodyDecoder<T> {

	public T decoder(ByteBuf buf) {
		
		Schema<String> schema = RuntimeSchema.getSchema(String.class);
		String s = new String();
		ProtostuffIOUtil.mergeFrom(buf.array(), s, schema);
		return null;
		
	}
}
