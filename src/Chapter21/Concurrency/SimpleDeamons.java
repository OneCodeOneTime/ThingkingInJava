package Chapter21.Concurrency;

import java.util.concurrent.TimeUnit;

public class SimpleDeamons implements Runnable{
	
	public static void main(String[] args) throws InterruptedException {
		for(int i=0;i<10;i++) {
			Thread deamon = new Thread(new SimpleDeamons());
			deamon.setDaemon(true);
			deamon.start();
		}
		System.out.println("All deamon start");
		//给守护线程启动的时间，不然main线程执行结束程序就结束了，时间短的话可能启动不到10个守护线程程序就结束了 
		TimeUnit.MICROSECONDS.sleep(15);
	}

	@Override
	public void run() {
		try {
			while(true) {
				TimeUnit.MICROSECONDS.sleep(100);
				System.out.println(Thread.currentThread()+" "+this);
			}
		}catch(InterruptedException e) {
			System.out.println("sleep() interrupted");
		}
	}

}
