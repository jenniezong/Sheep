package jvm.gc;

import java.util.ArrayList;

public class TestGC {

	
	
	public static void main(String[] args) {

		{ 
			byte[] _1MB = new byte[1024 * 1024]; 
		
		}
		
		int a = 1;
		System.gc();
	}

}
