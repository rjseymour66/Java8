package synchronizedbufferconcurrency;

import java.security.SecureRandom;

// Producer with a run method that inserts the values 1 to 10 in buffer.

public class Producer implements Runnable {

	private static final SecureRandom generator = new SecureRandom();
	private final Buffer sharedLocation; // reference to shared object
	
	// constructor
	public Producer(Buffer mSharedLocation) {
		sharedLocation = mSharedLocation;
	}
	
	// store values from 1 to 10 in sharedLocation
	public void run() {
				
		for (int count = 1; count <= 10; count++) {
			
			try { // sleep 0 to 3 seconds, then place value in Buffer
				
				Thread.sleep(generator.nextInt(3000)); // random sleep
				sharedLocation.blockingPut(count); // set value in buffer
				
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		
		System.out.printf("Producer done producing%nTerminating Producer%n");
	}
}
