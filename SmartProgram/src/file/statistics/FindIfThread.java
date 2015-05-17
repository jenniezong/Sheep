package file.statistics;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;

public class FindIfThread extends Thread {

	private JavaFile javaFile;
	private File resultFile;

	public FindIfThread(String name) {
		javaFile = new JavaFile(name);
	}

	@Override
	public void run() {
		super.run();
		javaFile.findIfInfo();

		File resultFile = new File("e:\\result.txt");
		FileOutputStream output = null;
		FileChannel channel = null;
		FileLock lock = null;

		try {
			if (!resultFile.exists()) {
				resultFile.createNewFile();
			}

			output = new FileOutputStream(resultFile, true);
			channel = output.getChannel();

			while (lock == null) {
				Thread.sleep(1000);
				try {
					lock = channel.tryLock();
				} catch (OverlappingFileLockException e) {
					e.printStackTrace();
				}
			}

			output.write(javaFile.ifInfosAndFileName().getBytes());
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} finally {

			try {
				if (lock != null) {
					lock.release();
				}
				channel.close();
				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
