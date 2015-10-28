package worker;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class FMMessageSendWorker extends BaseWorker<FMMessage>{

	private FMMessageSendTask task;
	private Executor executor = Executors.newFixedThreadPool(10);
	@Override
	public void execute() {

		try {
			queue = new LinkedBlockingQueue<FMMessage>();
			int threadNum = 100;
			for (int i = 0; i < threadNum; i++) {
				queue.add(new FMMessage());
			}
			countDownLatch = new CountDownLatch(threadNum);
			task = new FMMessageSendTask();
			task.setQueue(queue);
			task.setCountDownLatch(countDownLatch);
			executor.execute(task);

			countDownLatch.await(1000, TimeUnit.SECONDS);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
