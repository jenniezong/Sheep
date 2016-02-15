/**
 * 
 */
package com.nan.netty.codeC;

import java.util.List;

import com.jd.jr.stockservice.framework.socket.common.Message;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.internal.StringUtil;

/**
 * @author zongnan
 *
 */
public class StringBodyEncoder extends MessageToByteEncoder<Message<String>>{

	/* (non-Javadoc)
	 * @see io.netty.handler.codec.MessageToByteEncoder#encode(io.netty.channel.ChannelHandlerContext, java.lang.Object, io.netty.buffer.ByteBuf)
	 */
	@Override
	protected void encode(ChannelHandlerContext ctx, Message<String> msg,
			ByteBuf out) throws Exception {

		if(StringUtil.isNullOrEmpty(msg.getBody().getData())){
			
			
		}
	}

	private class SubStringEncoder extends StringBodyEncoder{
		
	}
}
