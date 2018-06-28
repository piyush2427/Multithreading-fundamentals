package reentrantLocks;

/** <p>
 * ReentrantLock class in Java as an alternative to synchronized code blocks. 
 * ReentrantLocks let you do all the stuff that you can do with synchronized, 
 * wait and notify, plus some more stuff besides that may come in handy from time to time.
 * </p>
 * 
 * <p>
 * @author piyush.pani
 * </p>
 */

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

	private int count = 0;
	private Lock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();

	private void increment() {
		for (int i = 0; i < 10000; i++) {
			count++;
		}
	}

	public void firstThread() throws InterruptedException {
		lock.lock();// synchronized block until unlock() is not called..

		System.out.println("Waiting ....");
		cond.await(); // wait()

		System.out.println("Woken up!");
		// CS should always be in a try block and finally should always release the lock, so that the lock is always released in finally in case of exception
		try {
			increment(); // CS i.e Critical section
		} finally {
			lock.unlock();
		}
	}

	public void secondThread() throws InterruptedException {

		Thread.sleep(1000);
		lock.lock();

		System.out.println("Press the return key!");
		new Scanner(System.in).nextLine();
		System.out.println("Got return key!");

		cond.signal(); // noti

		try {
			increment();
		} finally {
			lock.unlock();
		}
	}

	public void finished() {
		System.out.println("Count is: " + count);
	}
}