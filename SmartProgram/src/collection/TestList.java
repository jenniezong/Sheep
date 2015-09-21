package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TestList {

	public static final int NUM=50000;
	
	public static List values;
	
	static void randomVal () {
		Integer[] vals = new Integer[NUM];
		Random r = new Random();
		
		for(int i =0 , currval = 0 ; i < NUM ;i++) {
			vals[i] = new Integer(currval);
			currval += r.nextInt(100) +i;
		}
		
		values = Arrays.asList(vals);
	}
	
	static long timeList(List list) {
		long start = System.currentTimeMillis();
		for(int i = 0; i < NUM ;i++) {
			int index = Collections.binarySearch(list, values.get(i));
			if(index!=i)   
                System.out.println("***´íÎó***");   
		}
		
		return System.currentTimeMillis() - start;
	}
	
	public static void main(String[] args) {

		randomVal();
		System.out.println("ArrayListºÄÊ±£º" + timeList(new ArrayList(values)));
		System.out.println("LinkedListºÄÊ±£º" + timeList(new LinkedList(values)));
	}

}
