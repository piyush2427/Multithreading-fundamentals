package lowLevelProducerConsumer;

/** <p>
 * 	Implementing the producer-consumer pattern using "low level" techniques;
 *  namely, wait, notify and synchronized. This isn't the best way to implement
 *  a producer-consumer pattern in Java (see tutorial 7 for the best way);
 *  but this tutorial will help you to understand how to use wait and notify.
 * </p>
 * 
 * <p>
 * @author piyush.pani
 * </p>
 */

import java.util.LinkedList;
import java.util.Random;

public class Processor {

    private LinkedList<Integer> list = new LinkedList<Integer>();
    private final int LIMIT = 10;
    private Object lock = new Object();

    public void produce() throws InterruptedException {

        int value = 0;

        while (true) {

            synchronized (lock) {
                
                while(list.size() == LIMIT) {
                    lock.wait();
                }
                
                list.add(value++);
                lock.notify();
            }

        }
    }

    public void consume() throws InterruptedException {
        
        Random random = new Random();

        while (true) {

            synchronized (lock) {
                
                while(list.size() == 0) {
                    lock.wait();
                }
                
                System.out.print("List size is: " + list.size());
                int value = list.removeFirst();
                System.out.println("; value is: " + value);
                lock.notify();
            }
            
            Thread.sleep(random.nextInt(1000));
        }
    }
}