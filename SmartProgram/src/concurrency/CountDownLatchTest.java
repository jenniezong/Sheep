package concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CountDownLatchTest {
	private Executor executor = Executors.newFixedThreadPool(10);
	private static CountDownLatch latch;
	
	public static void main(String args[]) {
		latch = new CountDownLatch(10);
	}
}
