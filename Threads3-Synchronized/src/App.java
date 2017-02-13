
public class App {

	private int count = 0;
	/*synchronized keyword : If we call a synchronized method of a object, here, in this case we are calling 
	 * synchronized method of object app. Always to run synchronized method of object, we have to acquire the
	 *  intrinsic lock, and the thing is only one thread can acquire intrinsic lock at a time. Now, if one thread
	 *   acquire intrinsic lock and wants to run the method, and at the same time if another thread want to run the
	 *   same method, then second have to wait until the 1st thread releases the intrinsic lock.So the synchronized
	 *   keyword will work aquiring the intrinsic lock behind the scene.  */
	
	/*When multiple threads are accessing data, at that we should be aware that we don't need to use volatile keyword,
	 *  because if we are running something in synchronized block than its garranted that the current state of the 
	 *  variable will be visible to all threads.  */
	
	public  synchronized void increment(){
		count++;
	}
	
	public static void main(String[] args) {
		
		App app = new App();
		app.doWork();
		
	}
	
	public void doWork(){
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				
				for(int i=0; i<10000; i++){
					increment();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				
				for(int i=0; i<10000; i++){
					increment();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Count is:"+ count);
		
	}

}
