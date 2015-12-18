package com.nan.netty.study.common;

import java.io.File;

public class Test {

	public static void main(String[] args) {

		File file = new File("g:\\mktdt00.txt");
		Object[] objects = Mktdt00TXT.readTxtFile(file);
		System.out.println("HELLO");
		
	}

}
