package worker;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

public abstract class BaseWorker<T> {

	protected BlockingQueue<T> queue;
	
	protected Runnable task;
	
	protected CountDownLatch countDownLatch;
	
	public abstract void execute() ;
	
	public void beforeExecute() {
		System.out.println("BeforeExecute!");
	}
	
	public void doExecute() {
		beforeExecute();
		execute();
	}
}
