package Chapter21.Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FixedDiningPhilosophers {

	public static void main(String[] args) throws InterruptedException {
		int ponder = 5;
		int size = 5;
		ExecutorService exec = Executors.newCachedThreadPool();
		Chopstick[] sticks = new Chopstick[size];
		for(int i = 0;i<5;i++) {
			sticks[i] = new Chopstick();
		}
		for(int i = 0;i<size;i++) {
			if(i<(size-1)) {
				exec.execute(new Philosopher(sticks[i],sticks[i+1],i,ponder));
			}else {
				exec.execute(new Philosopher(sticks[0],sticks[i],i,ponder));
			}
		}
		TimeUnit.SECONDS.sleep(5);
		exec.shutdown();
	}

}
