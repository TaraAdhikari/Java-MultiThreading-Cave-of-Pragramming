package demo2;
/*There are two ways to create a thread:
 * 2nd) Java Thread Example by implementing Runnable interface.
 * 
 * If you are not extending the Thread class,your class object would not be treated
 * as a thread object.So you need to explicitly create Thread class object.
 * We are passing the object of your class that implements Runnable so that your 
 * class run() method may execute.*/


class Runner implements Runnable{

	public void run() {
		for (int i = 0; i < 10; i++) {

			System.out.println("hello" + i);

			try {
				Thread.sleep(300);/*
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
		Thread t1= new Thread(new Runner());
		Thread t2= new Thread(new Runner());
		
		t1.start();
		t2.start();
		
	}
}
