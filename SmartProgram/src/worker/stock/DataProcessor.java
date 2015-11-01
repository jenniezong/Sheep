package worker.stock;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class DataProcessor implements Runnable{

	private LinkedBlockingQueue<Stock> stockQueue;
	
	private	LinkedBlockingQueue<Integer> intQueue;
	
	private LinkedBlockingQueue<Double> doubleQueue;
	
	private List<Integer> sortedList;
	
	private List<Double> sortedDoubleList;
	
	private int newIntValue;
	
	private double newDoubleValue;
	
	public DataProcessor() {
	} 
	@Override
	public void run() {

		Stock stock = stockQueue.poll();
		newIntValue = intQueue.poll();
		newDoubleValue = doubleQueue.poll();
		sort(sortedList, newIntValue);
		sort(sortedDoubleList, newDoubleValue);
		
		printIntArray(sortedList);
		printIntArray(sortedDoubleList);
//		int idx = getIndex();
//		System.out.println("idx******************"+idx);
//		if(idx < 10) {
//			sort(sortedList);
//			sort(sortedDoubleList);
//		}
		
		
		// to cal 1 
		// cal 2
		// cal 3 
		// to redis
		// to DB
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("DataProcessor*********" + stock.getName());
	}
	public LinkedBlockingQueue<Stock> getStockQueue() {
		return stockQueue;
	}
	public void setStockQueue(LinkedBlockingQueue<Stock> stockQueue) {
		this.stockQueue = stockQueue;
	}
	
	public List<Integer> getSortedList() {
		return sortedList;
	}
	
	public void setSortedList(List<Integer> sortedList) {
		this.sortedList = sortedList;
	}
	
	public LinkedBlockingQueue<Integer> getIntQueue() {
		return intQueue;
	}
	public void setIntQueue(LinkedBlockingQueue<Integer> intQueue) {
		this.intQueue = intQueue;
	}
	
	public LinkedBlockingQueue<Double> getDoubleQueue() {
		return doubleQueue;
	}
	public void setDoubleQueue(LinkedBlockingQueue<Double> doubleQueue) {
		this.doubleQueue = doubleQueue;
	}
	public List<Double> getSortedDoubleList() {
		return sortedDoubleList;
	}
	public void setSortedDoubleList(List<Double> sortedDoubleList) {
		this.sortedDoubleList = sortedDoubleList;
	}
	public <T> void sort(List<T> sortedList, T newValue) {
		synchronized (sortedList) {
			int insertIndex = 0;
			if (newValue instanceof Double) {
				insertIndex = getDoubleIndex((List<Double>)sortedList,(Double)newValue);
			} else if (newValue instanceof Integer) {
				insertIndex = getIntIndex((List<Integer>)sortedList,(Integer)newValue);
			}
			if (insertIndex < 9) {
				for (int i = 9; i > insertIndex; i--) {
					Object tmp = sortedList.get(i - 1);
					sortedList.set(i, (T) tmp);
				}
				sortedList.set(insertIndex, newValue);

			} else if (insertIndex == 9) {
				sortedList.set(9, newValue);
			}

		}
	}
	
	private int getIntIndex(List<Integer> sortedList, Integer newValue) {
		int insertIndex = Collections.binarySearch(sortedList, newValue);
		if(insertIndex < 0) {
			insertIndex = -insertIndex-1;
		}
		
		return insertIndex;
	}
	
	private int getDoubleIndex(List<Double> sortedList, Double newValue) {
		int insertIndex = Collections.binarySearch(sortedList, newValue);
		if(insertIndex < 0) {
			insertIndex = -insertIndex-1;
		}
		
		return insertIndex;
	}
	
	public <T> void printIntArray(List<T> sortedList) {

		System.out.print("sort*********************");
		for (T i : sortedList) {
			System.out.print(i + "\t");
		}
		System.out.println();
	}
	
}
