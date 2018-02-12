package Chapter21.Concurrency;

import java.util.concurrent.locks.Lock;

public class TwinsLockTest {

	public static void main(String[] args) throws InterruptedException {
		final Lock lock = new TwinsLock();
		class Worker extends Thread{
			public void run() {
				while(true) {
					lock.lock();
					try {
						try {
							Thread.sleep(1000L);
							System.out.println(Thread.currentThread().getName());
							Thread.sleep(1000L);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}finally {
						lock.unlock();
					}
				}
			}
		}
		for(int i=0;i<10;i++){
			Worker w = new Worker();
			w.setDaemon(true);
			w.start();
		}
		for(int i=0;i<10;i++) {
			Thread.sleep(1000L);
			System.out.println();
		}
	}

}
