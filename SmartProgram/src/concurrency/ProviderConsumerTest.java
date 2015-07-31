package concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import concurrency.Provider.Data;

public class ProviderConsumerTest {
	
	private static int providerThreadCount = 10;
	private static int consumerThreadCount = 10;

	public static void main(String[] args) {

		BlockingQueue<Data> queue = new LinkedBlockingQueue<Data>();
		for (int i = 0 ;i < providerThreadCount; i++ ) {
			new Thread(new Provider(queue)).start();
		}
		
		for (int i = 0; i < consumerThreadCount; i ++) {
			new Thread(new Consumer(queue)).start();
		}
	}

}
