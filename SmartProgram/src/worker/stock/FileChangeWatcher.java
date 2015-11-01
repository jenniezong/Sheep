package worker.stock;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FileChangeWatcher {
	
	private static Map<File,Long> fileMap = new HashMap<File,Long>();
	private static File file = new File("C:\\SSEInfoNet\\QuoteReceiver\\data\\txt\\mktdt00.txt");
	public static void  main(String[] args) {
		fileMap.put(file, file.lastModified());
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					if (FileTransferToQueue.getInstance().isFinish()) {
						FileTransferToQueue.getInstance().transfer();
					}
//					for (File file : fileMap.keySet()) {
//						long modfied = file.lastModified();
//						long m = fileMap.get(file);
//						if(m != modfied && FileTransferToQueue.getInstance().isFinish()) {
//							fileMap.put(file, modfied);
//							FileTransferToQueue.getInstance().transfer();
//						}
//					}
					
				}
			}
		}).start();
	}
	
}
