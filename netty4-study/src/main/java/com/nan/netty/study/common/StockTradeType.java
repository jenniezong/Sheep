package com.nan.netty.study.common;


public enum StockTradeType {
	T("停牌"),
	F("正常交易"),
	G("退市");
	
	private String label;

	private StockTradeType(String label) {
		this.label = label;
	}

	public int value() {
		return ordinal();
	}

	public String label() {
		return label;
	}

	public static StockTradeType parse(int value) {
		for (StockTradeType e : values()) {
			if (e.value() == value)
				return e;
		}
		throw new IllegalArgumentException("No this enum value exists.");
	}
	
	public static int parse(String label) {
		for (StockTradeType e : values()) {
			if (e.toString().equals(label))
				return e.value();
		}
		throw new IllegalArgumentException("No this enum label exists.");
	}
	public static void main(String[] args) {
		System.out.println(StockTradeType.parse("N"));;
	}
}
