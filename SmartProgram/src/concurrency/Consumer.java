package concurrency;

import java.util.concurrent.BlockingQueue;

import concurrency.Provider.Data;

public class Consumer implements Runnable {

	private BlockingQueue<Data> datalist;

	public Consumer(BlockingQueue<Data> datalist) {
		this.datalist = datalist;
	}

	@Override
	public void run() {
		while(true) {
			try {
				System.out.println("Consumer*************************" + datalist.take().getName());
//				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Exception" + e);
			}
		}
			
	}

}
