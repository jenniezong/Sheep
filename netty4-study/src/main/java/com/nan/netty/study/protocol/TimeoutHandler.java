package com.nan.netty.study.protocol;

import java.util.concurrent.TimeUnit;

import io.netty.handler.timeout.ReadTimeoutHandler;

public class TimeoutHandler extends ReadTimeoutHandler{

	public TimeoutHandler(long timeout, TimeUnit unit) {
		super(timeout, unit);
		// TODO Auto-generated constructor stub
	}
	
	

}
