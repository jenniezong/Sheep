package concurrency.dateFormat;

import java.text.ParseException;

public class DateUtilTest {

	public static class SimpleDateFormatThreadSafe extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					System.out.println(this.getClass().getName() + " : "
							+ DateUtil.parse("2015-10-13 14:06:00"));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {

		for (int i = 0; i < 3; i++) {
			new SimpleDateFormatThreadSafe().start();
		}
	}

}
