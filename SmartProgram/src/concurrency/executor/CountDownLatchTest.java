package concurrency.executor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CountDownLatchTest {

	private final int threadNum = 10;
	private Executor executor = Executors.newFixedThreadPool(threadNum);
	private CountDownLatch start = new CountDownLatch(1);
	private CountDownLatch end = new CountDownLatch(threadNum);
	public static void main(String[] args) {

		CountDownLatchTest test = new CountDownLatchTest();
		System.out.println(System.nanoTime());
		test.executor.execute(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
			
		});
		test.start.countDown();
		
		
	}
	
	
	
	
	class Handler implements Runnable {

		@Override
		public void run() {
			try {
				start.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName());
			
			end.countDown();
		}
		
	}

}
