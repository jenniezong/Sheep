package com.nan.netty.study.common;

import java.io.File;

public class Test {

	public static void main(String[] args) {

		File file = new File(Test.class.getClassLoader().getResource("mktdt00.txt").getPath());
		Object[] objects = Mktdt00TXT.readTxtFile(file);
		System.out.println(objects.length);
		
	}

}
