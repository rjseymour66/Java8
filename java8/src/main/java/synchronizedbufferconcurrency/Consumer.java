package synchronizedbufferconcurrency;

import java.security.SecureRandom;

// Consumer with a run method that loops, reading 10 values from buffer.

public class Consumer implements Runnable {

	private static final SecureRandom generator = new SecureRandom();
	private final Buffer sharedLocation; // reference to shared object
	
	// constructor 
	public Consumer(Buffer mSharedLocation) {
		sharedLocation = mSharedLocation;
	}
	
	// read sharedLocation's value 10 times and sum the values
	public void run() {
		
		int sum = 0;
		
		for (int count = 1; count <= 10; count++) {
			
			// sleep 0 to 3 seconds, read value from buffer and add to sum
			try {
				
				Thread.sleep(generator.nextInt(3000));
				sum += sharedLocation.blockingGet();

			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		
		System.out.printf("%n%s %d%n%s%n",
				"Consumer read values totaling", sum, "Terminating Consumer");
	}
}
