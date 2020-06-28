package arrayblockingqueueconcurrency;

//Buffer interface specifies methods called by Producer and Consumer

public interface Buffer {

	// put int value into Buffer
	public void blockingPut(int value) throws InterruptedException;
	
	// get int value from Buffer
	public int blockingGet() throws InterruptedException;
}
