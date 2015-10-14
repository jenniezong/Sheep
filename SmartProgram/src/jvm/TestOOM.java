package jvm;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TestOOM {

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		Calendar cal = Calendar.getInstance();
		long start = cal.getTimeInMillis();
		
		while(true) {
//			String s = new String("abcdefghjklmnopqrstuvw");
			String s = "abcdefghjklmnopqrstuvw";
			list.add(s);
			long time = Calendar.getInstance().getTimeInMillis()-start;
			System.out.println("list size**************************" + time);
		}
	}

}
