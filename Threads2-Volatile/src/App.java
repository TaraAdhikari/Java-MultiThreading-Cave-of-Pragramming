import java.util.Scanner;

class Processor extends Thread{
	
	/*if we use the keyword volatile here, then this system will garranty to work in all
	 * systems and all implementations in java. Volatile keyword will prevent thread from 
	 * caching variables when they are not changed.  */
	
	private volatile boolean running = true;
	public void run(){
		
		while(running){
			System.out.println("Hello");
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void shutdown(){
		running = false;
	}
}


public class App {

	public static void main(String[] args) {
		Processor proc1 = new Processor();
		
		proc1.start();
		
		System.out.println("Press Enter key to stop...");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		
		proc1.shutdown();
	}

}
/*here 1st the output will come regularly and we cant stop the hello output else stop.
 * so, for that, we had added process that accepts boolean and when we hit enter key 
 * the process will stop */




/*Synchronization in Java:-

Synchronization in java is the capability to control the access of multiple threads to any shared resource.

Java Synchronization is better option where we want to allow only one thread to access the shared resource.

Why use Synchronization?
The synchronization is mainly used to

	1.To prevent thread interference.
	2.To prevent consistency problem.

Types of Synchronization:
	There are two types of synchronization
	1.Process Synchronization
	2.Thread Synchronization
	Here, we will discuss only thread synchronization.

Thread Synchronization

There are two types of thread synchronization mutual exclusive and inter-thread communication.

	1.Mutual Exclusive
		1.Synchronized method.
		2.Synchronized block.
		3.static synchronization.
	2.Cooperation (Inter-thread communication in java)
*/