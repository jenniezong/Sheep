package com.nan.netty.study.protocol;

public enum MessageType {

		REQUEST((byte)0),
		RESPONSE((byte)1),
		ONEWAY((byte)2),
		LOGREQ((byte)3),
		LOGRESP((byte)4),
		HEARTREQ((byte)5),
		HEARTRESP((byte)6),
		PUBLISH((byte)7);
		
		private byte value;
		
		private MessageType(byte value) {
			
			this.value = value;
		}
		
		public byte value() {
			return value;
		}
}
