package com.nan.netty.general.nio;


public class TimeServer {

	public static void main(String[] args) {

		int port = 8080;
		if(args != null && args.length > 0) {
			port = Integer.valueOf(args[0]);
		}
		MultipexerTimeServer timeServer = new MultipexerTimeServer(port);
		new Thread(timeServer,"NIO-MultiplexerTimeServer-001").start();
	}

}
