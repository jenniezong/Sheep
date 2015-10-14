package jvm;

public class TestStatic {

	
	public static void main(String[] args) {
		
		Runnable run1 = new Runnable() {
			
			@Override
			public void run() {
				StaticDog.setNum();
				System.out.println("Thread1*******************Num" + StaticDog.num);
				System.out.println("Thread1*******************LocalNum" + StaticDog.setLocalNum(11));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		Runnable run2 = new Runnable() {
			
			@Override
			public void run() {
				StaticDog.setNum();
				System.out.println("Thread2*******************Num" + StaticDog.num);
				System.out.println("Thread2*******************LocalNum" + StaticDog.setLocalNum(12));
			}
		};
		for (int i = 0 ; i<20; i++) {
			Thread thread1 = new Thread(run1);
			Thread thread2 = new Thread(run2);
			thread1.start();
			thread2.start();
		}
		
		
	}
}
