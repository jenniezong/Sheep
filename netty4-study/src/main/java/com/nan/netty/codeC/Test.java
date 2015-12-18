package com.nan.netty.codeC;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.msgpack.MessagePack;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.nan.netty.study.common.Mktdt00TXT;
import com.nan.netty.study.common.StockRealtime;

public class Test {

	public static void main(String[] args) throws IOException {

		List<StockRealtime> list = getData();
		MessagePack msgPack = new MessagePack();
		int len = 0;
		long start = System.currentTimeMillis();
		for(int i = 0;i < list.size();i ++) {
			byte[] b = msgPack.write(list.get(i));
			len = len + b.length;
		}
		long end = System.currentTimeMillis();
		System.out.println("Message pack size : " + len + " Time is " + (end - start) + "ms");
	    start = System.currentTimeMillis();
		System.out.println("JSON size : " + JSON.toJSONString(list).getBytes().length + " Time is " + (System.currentTimeMillis() - start) + "ms");
		
		
	}

	private static List<StockRealtime> getData() {
		File file = new File(Test.class.getClassLoader()
				.getResource("mktdt00.txt").getPath());
//		Object[] objects = Mktdt00TXT.readTxtFile(file);

		List<StockRealtime> list = Lists.newLinkedList();

		for (int i = 0; i < 10; i++) {
			Object[] objects = Mktdt00TXT.readTxtFile(file);
			list.addAll((List<StockRealtime>) objects[0]);
		}
		
		return list;
	}

}
