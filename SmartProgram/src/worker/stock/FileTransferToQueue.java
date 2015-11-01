package worker.stock;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.SortedSet;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class FileTransferToQueue{

	private File file = new File(
			"C:\\SSEInfoNet\\QuoteReceiver\\data\\txt\\mktdt00.txt");
	private Executor excutor = Executors.newFixedThreadPool(10);
	private LinkedBlockingQueue<Stock> stockQueue = new LinkedBlockingQueue<Stock>();
	private LinkedBlockingQueue<Integer> intQueue = new LinkedBlockingQueue<Integer>();
	private LinkedBlockingQueue<Double> doubleQueue = new LinkedBlockingQueue<Double>();
	private static FileTransferToQueue transfer = new FileTransferToQueue(true); 
//	public static volatile int lastModifiedValue;
	private List<Integer> sortedList = new ArrayList<Integer>(11);
	private List<Double> sortedDoubleList = new ArrayList<Double>(11);
	private boolean isFinish;
	private FileTransferToQueue (boolean isFinish) {
		sortedList.add(0);
		sortedList.add(1);
		sortedList.add(2);
		sortedList.add(3);
		sortedList.add(4);
		sortedList.add(5);
		sortedList.add(6);
		sortedList.add(7);
		sortedList.add(8);
		sortedList.add(9);
		
		sortedDoubleList.add(10.0);
		sortedDoubleList.add(10.0);
		sortedDoubleList.add(10.0);
		sortedDoubleList.add(10.0);
		sortedDoubleList.add(10.0);
		sortedDoubleList.add(10.0);
		sortedDoubleList.add(10.0);
		sortedDoubleList.add(10.0);
		sortedDoubleList.add(10.0);
		sortedDoubleList.add(10.0);
		
		this.isFinish = isFinish;
	}
	
	public static FileTransferToQueue getInstance() {
		return transfer;
	}
	public void transfer() {
		String encoding = "GBK";
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader reader = null;
		try {
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis, encoding);
			reader = new BufferedReader(isr);
			String lineTxt = new String();
			while ((lineTxt = reader.readLine())!= null) {
//				System.out.println("FileTransferToQueue**********"+lineTxt);
				if(lineTxt.startsWith("MD002|6") ){
					stockQueue.offer(cast(lineTxt), 100, TimeUnit.MILLISECONDS);
					intQueue.offer(randomInt(),100, TimeUnit.MILLISECONDS);
					doubleQueue.offer(randomDouble());
					DataProcessor pro = new DataProcessor();
					pro.setStockQueue(stockQueue);
					pro.setSortedList(sortedList);
					pro.setSortedDoubleList(sortedDoubleList);
					pro.setIntQueue(intQueue);
					pro.setDoubleQueue(doubleQueue);
					
					excutor.execute(pro);
					Thread.sleep(100);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				reader.close();
				isr.close();
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			isFinish = true;
		}
	}
	
	private Stock cast(String line) {
		Stock stock = new Stock();
		stock.setName(line);
		return stock;
	}

	public boolean isFinish() {
		return isFinish;
	}

//	public void setFinish(boolean isFinish) {
//		this.isFinish = isFinish;
//	}
	
	private int randomInt() {
		Random random = new Random();
		int rdm = random.nextInt(100);
		System.out.println("random****************"+ rdm);
		return rdm;
	}
	
	private double randomDouble() {
		Random random = new Random();
		double d = random.nextDouble();
		return d;
	}
}
