package arrayblockingqueueconcurrency;

import java.util.concurrent.ArrayBlockingQueue;

// Creating a synchronized buffer using the ArrayBlockingQueue class

public class BlockingBuffer implements Buffer {
	
	private final ArrayBlockingQueue<Integer> buffer; // shared buffer
	
	public BlockingBuffer() {
		buffer = new ArrayBlockingQueue<Integer>(1);
	}
	
	// place value into buffer
	public void blockingPut(int value) throws InterruptedException {
		buffer.put(value); // place value in buffer
		System.out.printf("%s%2d\t%s%d%n", "Producer writes ", value,
				"Buffer cells occupied: ", buffer.size());
	}
	
	// return value from buffer
	public int blockingGet() throws InterruptedException {
		int readValue = buffer.take(); // remove value from buffer
		System.out.printf("%s %2d\t%s%d%n", "Consumer reads ",
				readValue, "Buffer cells occupied: ", buffer.size());
		
		return readValue;
	}
}
