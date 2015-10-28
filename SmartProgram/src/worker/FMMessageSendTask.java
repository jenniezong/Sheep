package worker;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

public class FMMessageSendTask implements Runnable{

	private BlockingQueue<FMMessage> queue;
	private CountDownLatch countDownLatch;
	
	@Override
	public void run() {

		try {
			FMMessage msg = queue.poll();
			System.out.println(msg.toString());
			Thread.sleep(2000);
			countDownLatch.countDown();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public void setQueue(BlockingQueue<FMMessage> queue) {
		this.queue = queue;
	}

	public void setCountDownLatch(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}
	
	

}
