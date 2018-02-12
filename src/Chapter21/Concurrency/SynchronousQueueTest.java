package Chapter21.Concurrency;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueTest {
	static SynchronousQueue<String> sq = new SynchronousQueue<>();
	
	public static void main(String[] args) throws InterruptedException {
		TakeT takeT = new TakeT();
		PutT putT = new PutT();
		Thread t1 = new Thread(takeT);
		Thread p1 = new Thread(putT);
		
		p1.start();
		Thread.sleep(10000L);
		t1.start();
		Thread.sleep(5000L);
		System.out.println(sq);
	}
	
	static class TakeT implements Runnable{
		@Override
		public void run() {
			try {
				System.out.println(sq.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	static class PutT implements Runnable{
		
		@Override
		public void run() {
			try {
				sq.put("2018-01-16");
				System.out.println("放入一个元素");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
