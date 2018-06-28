package syncrhonized;

/**
 * <p>
 *		Threads interlocking and the synchronized keyword:
 * </p>
 * 
 * <p>
 * @author piyush.pani
 * </p>
 */

public class Worker {
    private int count = 0;
    
    public synchronized void increment() {
        count++;
    }
    
    public static void main(String[] args)
    {
    	Worker worker = new Worker();
    	worker.run();
    }
    public void run() {
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                for(int i = 0; i < 5; i++) {
                	System.out.println("t1");
                    increment();
                }
            }
        });
        thread1.start();
        
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                for(int i = 0; i < 5; i++) {
                   	System.out.println("t2");
                    increment();
                }
            }
        });
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Count is: " + count);
    }
}