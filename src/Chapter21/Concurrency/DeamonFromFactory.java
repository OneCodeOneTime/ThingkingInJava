package Chapter21.Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DeamonFromFactory implements Runnable {

	@Override
	public void run() {
		while(true) {
			try {
				TimeUnit.MICROSECONDS.sleep(100);
				System.out.println(Thread.currentThread()+" "+this);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool(new DeamonThreadFactory());
		for(int i=0;i<10;i++) {
			exec.execute(new DeamonFromFactory());
			System.out.println("All deamons started");
			TimeUnit.MICROSECONDS.sleep(500);
		}
	}

}
