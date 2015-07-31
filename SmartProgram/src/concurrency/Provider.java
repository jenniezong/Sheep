package concurrency;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Provider implements Runnable {

	private BlockingQueue<Data> dataQueue;

	public Provider(BlockingQueue<Data> queue) {
		this.dataQueue = queue;
	}
	class Data {

		private String name;

		public void simulator() {
			this.name = getRandomString(10);
		}

		private String getRandomString(int length) {
			StringBuffer buffer = new StringBuffer(
					"0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
			StringBuffer sb = new StringBuffer();
			Random random = new Random();
			int range = buffer.length();
			for (int i = 0; i < length; i++) {
				sb.append(buffer.charAt(random.nextInt(range)));
			}
			return sb.toString();
		}

		public String getName() {
			return name;
		}
		
	}

	@Override
	public void run() {
		while(true) {
			Data data = new Data();
			data.simulator();
			try {
				dataQueue.put(data);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Provider*************************" + data.getName());
		}
	}
}
