import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable{
	private int id;
	
	public Processor(int id){
		this.id= id;
	}
	
	public void run(){
		System.out.println("Starting:"+ id);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Completed:" + id);
		
	}
}

public class App {

	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		/*will create 2 new threads Eg: 2 workers in the factory. suppose, we have 5 tasks.we want
		 *  each of these workers or threads to process the task, so, when a worker finishes a task, 
		 * we want the worker to start a new task.*/
		
		for(int i=0; i<5; i++){//taking 5 tasks in this example
			executor.submit(new Processor(i));//submitting task one by one by processor id 
		}
		
		executor.shutdown();//after finishing the task it will shutdown but it will not shutdown immediately, but will wait for all threads to complete submitting
		
		System.out.println("All tasks Submitted");
		
		try { //now we need to wait for all task to complete its job
			executor.awaitTermination(1, TimeUnit.DAYS);//this will wait for 1 day, and if not completed also it will return
		} catch (InterruptedException e) {
			}
		
		System.out.println("All tasks Completed");
		
		
		
	}
}
/*Java Thread pool represents a group of worker threads that are waiting for the job and 
 * reuse many times.

	In case of thread pool, a group of fixed size threads are created. A thread from the thread
	 pool is pulled out and assigned a job by the service provider. After completion of the job,
	  thread is contained in the thread pool again.
	  OUTPUT:------------------------------------------------->>>>
	    Starting:1
		Starting:0
		All tasks Submitted
		Completed:1
		Completed:0
		Starting:2
		Starting:3
		Completed:3
		Completed:2
		Starting:4
		Completed:4
		All tasks Completed
	  */
