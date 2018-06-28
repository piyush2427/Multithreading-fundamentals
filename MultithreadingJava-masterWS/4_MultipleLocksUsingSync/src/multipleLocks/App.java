package multipleLocks;

/** <p>
 * This is the fourth part of the advanced Java multi-threading tutorial. 
 * In this tutorial we can use multiple locks to speed up complex multi-threaded
 *  code, sometimes dramatically.
 * </p>
 * 
 * <p>
 * @author piyush.pani
 * </p>
 */

public class App {

	public static void main(String[] args) {

		Worker worker = new Worker();
		worker.main();
	}

}
