package extendingThread;
/**
 * @author piyush.pani
 *
 */
class Runner extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName()+ " Hello: " + i);
			
			try {
				Thread.sleep(100);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}


public class Application {

	public static void main(String[] args) throws InterruptedException {
		Runner runner1 = new Runner();
		runner1.start();
		//runner1.join();
		Runner runner2 = new Runner();
		runner2.start();
		

	}

}