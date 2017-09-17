package Chapter21.Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimplePrioritues implements Runnable {
	private int countDown = 5;
	private volatile double d;
	private int priority;
	public SimplePrioritues(int priority) {
		this.priority = priority;
	}
	public String toString() {
		return Thread.currentThread()+": "+countDown;
	}
	
	@Override
	public void run() {
		Thread.currentThread().setPriority(priority);
		while(true) {
			for(int i=1;i<100000;i++) {
				d += (Math.PI+Math.E)/(double)i;
				if(i%1000 == 0) {
					//线程从运行变为就绪，有可能再次运行
					Thread.yield();
					//System.out.println("after yield");
				}
			}
			System.out.println(this);
			if(--countDown == 0) {
				return;
			}
		}
	}

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i=0;i<5;i++) {
			exec.execute(new SimplePrioritues(Thread.MIN_PRIORITY));
		}
		exec.execute(new SimplePrioritues(Thread.MAX_PRIORITY));
		exec.shutdown();
	}

}
