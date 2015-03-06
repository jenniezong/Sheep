package test;

import java.util.Calendar;
import java.util.Date;

public class TestThread {

	public static void main(String[] args) {
		Date curTime = Calendar.getInstance().getTime();
		System.out.println(curTime);
		
		AutoInstallNeMsg.getInstance().updateMsg("Installed NE:sp110-237 with NEId:5007 from EM:linux-84", curTime);
		System.out.println(AutoInstallNeMsg.getInstance().getNum()+"    "+AutoInstallNeMsg.getInstance().getEmName());
		
		
		try {
			Thread.sleep(20*100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(AutoInstallNeMsg.getInstance().getNum()+"    "+AutoInstallNeMsg.getInstance().getEmName());
		
		try {
			Thread.sleep(30*100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(AutoInstallNeMsg.getInstance().getNum()+"    "+AutoInstallNeMsg.getInstance().getEmName());
		
		curTime = Calendar.getInstance().getTime();
		System.out.println(curTime);
		
		AutoInstallNeMsg.getInstance().updateMsg("Installed NE:sp110-237 with NEId:5007 from EM:linux-84", curTime);
		System.out.println(AutoInstallNeMsg.getInstance().getNum()+"    "+AutoInstallNeMsg.getInstance().getEmName());
		
		
		try {
			Thread.sleep(10*100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		curTime = Calendar.getInstance().getTime();
		System.out.println(curTime);
		
		AutoInstallNeMsg.getInstance().updateMsg("Installed NE:sp110-237 with NEId:5007 from EM:linux-83", curTime);
		System.out.println(AutoInstallNeMsg.getInstance().getNum()+"    "+AutoInstallNeMsg.getInstance().getEmName());

	}
	

}
