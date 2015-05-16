package MultipleThread;

public class TestDeadLock {
    

    public static A a = new A();
    public static B b = new B();
    public static void main(String[] args) {

	
    }
    
    class Thread1 extends Thread {
	
	public void run() {
	    
	    a.m();
	}
    }
    
    class Thread2 extends Thread {
	
	 public void run() {
	    b.m(); 
	     
	 }
    }

}


class A {
	
	public synchronized void m()
	{
	    try {
		Thread.sleep(60000);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
}

class B {
	
	public synchronized void m () {
	    
	    try {
		Thread.sleep(60000);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
}

