package Chapter21.Concurrency;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		CountDownLatch latch = new CountDownLatch(100);
		for(int i = 0;i<10;i++) {
			exec.execute(new WaitingTask(latch));
		}
		for(int i = 0;i<100;i++) {
			exec.execute(new TaskPortion(latch));
		}
		System.out.println("Launched all tasks");
		exec.shutdown();
		
	}

}


class TaskPortion implements Runnable{
	private static int counter = 0;
	private final int id = counter++;
	private static Random rand = new Random(47);
	private final CountDownLatch latch;
	public TaskPortion(CountDownLatch latch) {
		this.latch = latch;
	}
	
	@Override
	public void run() {
		try {
			doWork();
			latch.countDown();
		}catch(InterruptedException ex) {
			
		}
	}
	
	public void doWork() throws InterruptedException {
		TimeUnit.MICROSECONDS.sleep(rand.nextInt(2000));
		System.out.println(this+"completed");
	}
	
	public String toString() {
		return String.format("%1$-3d ", id);
	}
}

class WaitingTask implements Runnable{
	private static int counter = 0;
	private final int id = counter++;
	private final CountDownLatch latch;
	WaitingTask(CountDownLatch latch){
		this.latch = latch;
	}
	@Override
	public void run() {
		try {
			latch.await();
			System.out.println(this+" run");
		}catch(InterruptedException ex) {
			System.out.println(this+" interrupted");
		}
	}
	
	public String toString() {
		return String.format("WaitingTask %1$-3d ", id);
	}
}