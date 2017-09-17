package Chapter21.Concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DeadlockingDiningPhilosophers {

	public static void main(String[] args) throws InterruptedException {
		int ponder = 5;
		int size = 5;
		ExecutorService exec = Executors.newCachedThreadPool();
		Chopstick[] sticks = new Chopstick[size];
		for(int i = 0;i<size;i++) {
			sticks[i] = new Chopstick();
		}
		for(int i = 0;i<size;i++) {
			exec.execute(new Philosopher(sticks[i],sticks[(i+1)%size],i,ponder));
		}
		TimeUnit.SECONDS.sleep(5);
		exec.shutdown();
	}

}

class Chopstick{
	private boolean taken = false;
	public synchronized void taken() throws InterruptedException {
		while(taken) {
			wait();
		}
		taken = true;
	}
	public synchronized void drop() {
		taken = false;
		this.notifyAll();
	}
}

class Philosopher implements Runnable{
	private Chopstick left;
	private Chopstick right;
	private final int id;
	private final int ponderFactor;
	private Random rand = new Random(47);
	
	private void pause() throws InterruptedException {
		if(ponderFactor == 0){
			return;
		}
		TimeUnit.MICROSECONDS.sleep(rand.nextInt(ponderFactor*250));
	}
	
	public Philosopher(Chopstick left,Chopstick right,int ident,int ponder) {
		this.left = left;
		this.right = right;
		this.id = ident;
		this.ponderFactor = ponder;
	}
	
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				System.out.println(this+" "+"thinking");
				pause();
				System.out.println(this+" "+"grabbing right");
				right.taken();
				System.out.println(this+" "+"grabbing left");
				left.taken();
				System.out.println(this+" "+"eating");
				pause();
				right.drop();
				left.drop();
			}
		}catch(InterruptedException e) {
			System.out.println(this+" "+"exiting via interrupt");
		}
	}

	@Override
	public String toString() {
		return "Philosopher [id=" + id + "]";
	}
	
	
}
