package file.statistics;

import java.io.File;
import java.io.IOException;

public class Test {
	
	

	public static void main(String[] args) {

		
		FindIfThread thread1 = new FindIfThread("e:\\Test1.java");
    	thread1.start();
    	FindIfThread thread2 = new FindIfThread("e:\\Test2.java");
    	thread2.start();
    	FindIfThread thread3 = new FindIfThread("e:\\Test3.java");
    	thread3.start();
    	FindIfThread thread4 = new FindIfThread("e:\\Test4.java");
    	thread4.start();
    	FindIfThread thread5 = new FindIfThread("e:\\Test5.java");
    	thread5.start();
    	FindIfThread thread6 = new FindIfThread("e:\\Test6.java");
    	thread6.start();
    	FindIfThread thread7 = new FindIfThread("e:\\Test7.java");
    	thread7.start();
    	FindIfThread thread8 = new FindIfThread("e:\\Test8.java");
    	thread8.start();
    	FindIfThread thread9 = new FindIfThread("e:\\Test9.java");
    	thread9.start();
    	FindIfThread thread10 = new FindIfThread("e:\\Test10.java");
    	thread10.start();
	}

}
