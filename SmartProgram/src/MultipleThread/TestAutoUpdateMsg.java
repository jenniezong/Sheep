package MultipleThread;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;


/**
 * Requirment:
 * 
 * There are three thread.
 * 1 thread is prepared to update the number.
 * one thread is used to print the message.
 * The last thread is to initialize the data every 30 seconds.
 * 
 * Used the interrupt method to stop the sleeping method.
 * @author enanzon
 *
 */
public class TestAutoUpdateMsg {
	
	private static Thread updateMsgThread;
	private static Thread printMsgThread;

	public static void main(String[] args) {
		
		final Random rand = new Random();
		updateMsgThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
			
				while(true)
				{
					try {
						int sleepTime = rand.nextInt(5);
						Thread.sleep(sleepTime*1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Date curTime = Calendar.getInstance().getTime();
					System.out.println(curTime);
					AutoInstallNeMsg.getInstance().updateMsg("Installed NE:sp110-237 with NEId:5007 from EM:linux-84", curTime);
				}
				
			}
		});
		updateMsgThread.start();
		
		printMsgThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true)
				{
					try {
						Thread.sleep(3*1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Date curTime = Calendar.getInstance().getTime();
					System.out.println(curTime);
					System.out.println(AutoInstallNeMsg.getInstance().getNum()+"    "+AutoInstallNeMsg.getInstance().getEmName());
				}
			}
		});
		printMsgThread.start();
		
	}
	
	

}
