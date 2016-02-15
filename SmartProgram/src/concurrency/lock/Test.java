/**
 * 
 */
package concurrency.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zongnan
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		N nn = new N();
		nn.n1();
		nn.n2();
//		M ins = new M();
//		ins.m1();
//		ins.m2();

	}

}

class M {
	
	public synchronized void m1() {
		System.out.println("m1获取sync锁");
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("m1释放sync锁");
	}
	
	public synchronized void m2() {
		System.out.println("m2释放sync锁");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("m2释放sync锁");
	}
}

class N {
	
	Lock lock = new ReentrantLock();
	
	public void n1() {
		lock.tryLock();
		System.out.println("n1获取sync锁");
		try {
			lock.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
			System.out.println("n1释放sync锁");
		}
	}
	
	public void n2() {
		lock.tryLock();
		System.out.println("n2获取sync锁");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
			System.out.println("n2释放sync锁");
		}
	}
	
}
