/**
 * 
 */
package com.nan.netty.codeC;

import java.util.List;

import com.jd.jr.stockservice.framework.socket.common.Body;
import com.jd.jr.stockservice.framework.socket.common.Header;
import com.jd.jr.stockservice.framework.socket.common.Message;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @author zongnan
 *
 */
public class StringBodyDecoder extends StringDecoder{

	/* (non-Javadoc)
	 * @see io.netty.handler.codec.ByteToMessageDecoder#decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List)
	 */
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in,
			List<Object> out) throws Exception {
		super.decode(ctx, in, out);
		
		Message<String> msg = new Message<String>();
		msg.setHeader((Header) out.get(0));
		Body<String> body = new Body<String>();
		msg.setBody(body);
		
	}

}
