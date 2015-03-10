package MultipleThread;

import java.util.Date;

public class AutoInstallNeMsg {

	private int num = 0;
	private String emName = "";
	private Date time;
	private static AutoInstallNeMsg autoInstallNeMsg = new AutoInstallNeMsg();
	private Thread waitThread;

	private AutoInstallNeMsg() {
		initData();
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
		System.out.println("Auto init data start!!!!!!!!!!");
		autoInitData();

	}

	public String getEmNameFromDetails(String details) {
		String[] subStr = details.split(":");
		return subStr[3];
	}
	

	private void autoInitData() {
		
		if(waitThread != null )
		{
			waitThread.interrupt();
			
		}
		
		waitThread = new Thread(new Runnable() {

			@Override
			public void run() {
					try {
						Thread.sleep(2 * 1000);
						initData();
						System.out.println("Init data completed!");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
				
		});
		waitThread.start();
		
	}
}
