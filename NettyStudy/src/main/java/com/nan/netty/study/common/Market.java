package com.nan.netty.study.common;

import java.util.TimeZone;

public enum Market {
	CN("沪深", "PRC"),
	HK("港股", "Hongkong"),
	US("美股", "America/New_York");

	private String label;
	private String timeZone;

	private Market(String label, String timeZone) {
		this.label = label;
		this.timeZone = timeZone;
	}

	public int value() {
		return ordinal();
	}

	public String label() {
		return label;
	}
	
	public TimeZone timeZone() {
		return TimeZone.getTimeZone(timeZone);
	}

	public static Market parse(int value) {
		for (Market e : values()) {
			if (e.value() == value)
				return e;
		}
		throw new IllegalArgumentException("No this enum value exists.");
	}
}
