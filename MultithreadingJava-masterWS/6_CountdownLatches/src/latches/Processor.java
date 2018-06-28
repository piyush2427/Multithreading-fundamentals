package latches;

/** <p>
 *	Using the excellent CountDownLatch Java class to synchronize your threads' activities..
 * </p>
 * 
 * <p>
 * @author piyush.pani
 * </p>
 */

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor implements Runnable {
    private CountDownLatch latch;
    
    public Processor(CountDownLatch latch) {
        this.latch = latch;
    }
    
    public void run() {
        System.out.println("Started.");
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        latch.countDown();
    }
}