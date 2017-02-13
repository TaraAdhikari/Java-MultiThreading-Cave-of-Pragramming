package demo1;

/*There are two ways to create a thread:

1st) By extending Thread class*/

class Runner extends Thread {
	public synchronized void run() {

		for (int i = 0; i < 10; i++) {

			System.out.println("hello" + i);

			try {
				Thread.sleep(2000);/*
								 * sleep()is the static method of the thread
								 * class.Causes the currently executing thread
								 * to sleep (temporarily cease execution) for
								 * the specified number of milliseconds.
								 */
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class App {

	public static void main(String[] args) {
		Runner runner1 = new Runner();
		runner1.start();
		
		System.out.println("first");
		
		Runner runner2 = new Runner();
		runner2.start();
		System.out.println("last");
	}

}
