package test;

import java.util.Date;

public class AutoInstallNeMsg {

	private int num = 0;
	private String emName = "";
	private Date time;
	private static AutoInstallNeMsg autoInstallNeMsg = new AutoInstallNeMsg();
	private Boolean flag = false;
	private Thread notifyThread;
	private Thread waitThread;

	private AutoInstallNeMsg() {
		initData();
//		autoUpdateMsg();
	}

	public static AutoInstallNeMsg getInstance() {
		return autoInstallNeMsg;
	}

	private void initData() {
		num = 0;
		emName = "";
		time = new Date();

	}

	public int getNum() {
		return num;
	}

	public String getEmName() {
		return emName;
	}

	public Date getTime() {
		return time;
	}

	public synchronized void updateMsg(String details, Date time) {

		String em = getEmNameFromDetails(details);
		if (num > 0 && !this.emName.equals(em)) {
			num = 1;
		} else {
			num++;
		}
		this.emName = em;
		this.time = time;
		System.out.println("updateMag!!!!!!!!!!");
		autoUpdateMsg();

	}

	public String getEmNameFromDetails(String details) {
		String[] subStr = details.split(":");
		return subStr[3];
	}

	private void autoUpdateMsg() {
		
		waitThread = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized(flag) {
					try {
						Thread.sleep(30 * 100);
						System.out.println("notify!!!!!!!!!!!");
						flag.notifyAll();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		});
		waitThread.start();
		
		notifyThread = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (flag) {
					try {
						initData();
						System.out.println("wait!!!!!!!!!!!");
						flag.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		});
		notifyThread.start();

		
		
		
		
		
	}
}
