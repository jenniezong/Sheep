/**
 * 
 */
package com.nan.netty.codeC;

import java.util.List;

import com.jd.jr.stockservice.framework.socket.common.Message;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.MessageToMessageEncoder;

/**
 * @author zongnan
 *
 */
public class MessageObjectEncoder extends MessageToByteEncoder<Message> {


	/* (non-Javadoc)
	 * @see io.netty.handler.codec.MessageToByteEncoder#encode(io.netty.channel.ChannelHandlerContext, java.lang.Object, io.netty.buffer.ByteBuf)
	 */
	@Override
	protected void encode(ChannelHandlerContext ctx, Message msg, ByteBuf out)
			throws Exception {
		out.writeByte(msg.getHeader().getVersion().value());
		out.writeByte(msg.getHeader().getType().value());
		if(msg.getBody() != null && msg.getBody().length > 0) {
			out.writeBytes(msg.getBody());
		}
	}

}
