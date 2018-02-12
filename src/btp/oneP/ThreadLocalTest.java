package btp.oneP;

import java.util.concurrent.Executors;

public class ThreadLocalTest {

	public static void main(String[] args) throws InterruptedException {
		Integer o = new Integer(100);
		ThreadLocal1 tl1 = new ThreadLocal1(o);
		ThreadLocal1 tl2 = new ThreadLocal1(o);
		Thread t1 = new Thread(tl1);
		Thread t2 = new Thread(tl2);
		t1.start();
		t2.start();
		Thread.sleep(10000);
		
		Executors.newCachedThreadPool();
		Executors.newFixedThreadPool(0);
	}

}


class ThreadLocal1 implements Runnable{
	private final ThreadLocal<Integer> tl = new ThreadLocal<Integer>() {
		@Override  
        protected Integer initialValue() {  
			Integer conn = null; 
            return conn;  
        }  
	};
	public ThreadLocal1(Integer o) {
		System.out.println("---set"+o);
		tl.set(o);
	}
	@Override
	public void run() {
		System.out.println(tl);
		System.out.println(Thread.currentThread()+":"+tl.get());
	}
}