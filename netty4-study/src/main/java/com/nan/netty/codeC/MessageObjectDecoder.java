/**
 * 
 */
package com.nan.netty.codeC;

import java.util.List;

import com.jd.jr.stockservice.framework.socket.common.Header;
import com.jd.jr.stockservice.framework.socket.common.Message;
import com.jd.jr.stockservice.framework.socket.common.MsgType;
import com.jd.jr.stockservice.framework.socket.common.MsgVersion;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.MessageToMessageDecoder;

/**
 * @author zongnan
 *
 */
public class MessageObjectDecoder extends ByteToMessageDecoder{


	/* (non-Javadoc)
	 * @see io.netty.handler.codec.ByteToMessageDecoder#decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List)
	 */
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in,
			List<Object> out) throws Exception {
		Message msg = new Message();
		Header head = new Header();
		head.setVersion(MsgVersion.valueOf(in.readByte()));
		head.setType(MsgType.valueOf(in.readByte()));
		msg.setHeader(head);
		int len = in.readableBytes();
		if(len > 0) {
			byte[] body = new byte[len];
			in.readBytes(body);
			msg.setBody(body);
		}
		out.add(msg);
		
	}


	
}
