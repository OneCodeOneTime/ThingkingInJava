package Chapter21.Concurrency;

import java.util.concurrent.TimeUnit;

public class Deamons {

	public static void main(String[] args) throws InterruptedException {
		Thread d = new Thread(new Deamon());
		d.setDaemon(true);
		d.start();
		System.out.println("d.isDeamon() = "+d.isDaemon()+",");
		TimeUnit.SECONDS.sleep(1);
	}

}

class DeamonSpawn implements Runnable{

	@Override
	public void run() {
		while(true) {
			Thread.yield();
		}
	}
	
}

class Deamon implements Runnable{
	private Thread[] t = new Thread[10];
	@Override
	public void run() {
		for(int i=0;i<t.length;i++) {
			t[i] = new Thread(new DeamonSpawn());
			t[i].start();
			System.out.println("DeamnSpawn "+i+" started");
		}
		for(int i=0;i<t.length;i++) {
			System.out.println("t["+i+"].isDeamon() = "+t[i].isDaemon());
		}
		while(true) {
			Thread.yield();
		}
	}
	
}
