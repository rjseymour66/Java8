package synchronizedbufferconcurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Application with two threads manipulating an unsynchronized buffer

public class SharedBufferTest2 {

	public static void main(String[] args) throws InterruptedException {
		
		// create new thread pool with two threads
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		// create UnsynchronizedBuffer to store ints
		Buffer sharedLocation = new SynchronizedBuffer();
		
		System.out.printf("%-40s%s\t\t%s%n-40%s%n%n", "Operation", "Buffer", "Occupied",
				"----------", "------\t\t--------");
		
		// execute the Producer and Consumer, giving each 
		// access to the sharedLocation
		executorService.execute(new Producer(sharedLocation));
		executorService.execute(new Consumer(sharedLocation));
		
		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.MINUTES);
	}
}
