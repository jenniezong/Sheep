package concurrency;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class NoVisibility {

	private static boolean ready;
	private static int number;
	private static AtomicInteger atomicInt;
	
	
	private static class ReaderThread extends Thread {
		public void run() {
			while (!ready) {
				Thread.yield();
			}
		}
	}
	
	public synchronized static void  write() {
		number++;
		if(number < 10) {
			
		}
	}
	
	public synchronized static void  read() {
		System.out.print(number);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
