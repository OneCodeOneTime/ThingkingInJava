package Chapter21.Concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

import Chapter21.Concurrency.PrioritizedTask.EndSentinel;

public class PriorityBlockingQueueDemo {

	public static void main(String[] args) {
		Random rand = new Random(47);
		ExecutorService exec = Executors.newCachedThreadPool();
		PriorityBlockingQueue<Runnable> queue = new PriorityBlockingQueue<Runnable>();
		exec.execute(new PrioritizedTaskProducter(queue,exec));
		exec.execute(new PrioritizedTaskConsumer(queue));
	}

}

class PrioritizedTask implements Runnable,Comparable<PrioritizedTask>{
	private Random rand = new Random(47);
	private static int counter = 0;
	private final int id = counter++;
	private final int priority;
	private static List<PrioritizedTask> sequence = new ArrayList<PrioritizedTask>();
	public PrioritizedTask(int priority) {
		this.priority = priority;
		sequence.add(this);
	}
	
	@Override
	public int compareTo(PrioritizedTask o) {
		return priority<o.priority?1:(priority>o.priority?-1:0);
	}

	@Override
	public void run() {
		try {
			TimeUnit.MICROSECONDS.sleep(rand.nextInt(250));
		}catch(InterruptedException e) {
			
		}
		System.out.println(this);
	}

	public int getId() {
		return id;
	}

	public int getPriority() {
		return priority;
	}
	
	public String summary() {
		return "("+id+":"+priority+")";
	}
	
	public static class EndSentinel extends PrioritizedTask{
		private ExecutorService exec;
		public EndSentinel(ExecutorService e) {
			super(-1);
			exec = e;
		}
		public void run() {
			int count = 0;
			for(PrioritizedTask pt:sequence) {
				System.out.print(pt.summary());
				if(++count%5==0) {
					System.out.println();
				}
			}
			System.out.println();
			System.out.println(this+" calling shutdownnow()");
			exec.shutdownNow();
		}
	}
}

class PrioritizedTaskProducter implements Runnable{
	private Random rand = new Random(47);
	private Queue<Runnable> queue;
	private ExecutorService exec;
	public PrioritizedTaskProducter(Queue<Runnable> queue,ExecutorService exec) {
		this.queue = queue;
		this.exec = exec;
	}
	@Override
	public void run() {
		for(int i = 0;i<20;i++) {
			queue.add(new PrioritizedTask(rand.nextInt(10)));
			Thread.yield();
		}
		try {
			for(int i = 0;i<10;i++) {
				TimeUnit.MICROSECONDS.sleep(250);
				queue.add(new PrioritizedTask(10));
			}
			for(int i = 0;i<10;i++) {
				TimeUnit.MICROSECONDS.sleep(250);
				queue.add(new PrioritizedTask(i));
			}
			queue.add(new PrioritizedTask.EndSentinel(exec));
		}catch(InterruptedException e) {
			
		}
		System.out.println("Finished PrioritizedTaskProductor");
	}
	
}

class PrioritizedTaskConsumer implements Runnable{
	private PriorityBlockingQueue<Runnable> q;
	public PrioritizedTaskConsumer(PriorityBlockingQueue<Runnable> q) {
		this.q = q;
	}
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				q.take().run();
			}
		}catch(InterruptedException e) {
			
		}
		System.out.println("Finished PrioritizedTaskConsumer");
	}
	
}