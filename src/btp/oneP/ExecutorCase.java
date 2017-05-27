package btp.oneP;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorCase {
	private static Executor executor = Executors.newFixedThreadPool(10);
	public static void main(String[] args) {
		for(int i=0;i<20;i++){
			executor.execute(new Task());
		}

	}
	static class Task implements Runnable{
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName());
		}
	}
	
	public static ExecutorService newFixedThreadPool(int nThreads){
		return new ThreadPoolExecutor(nThreads, 2*nThreads, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
	}
	

}
