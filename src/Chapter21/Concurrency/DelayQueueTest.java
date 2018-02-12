package Chapter21.Concurrency;

import java.util.Date;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DelayQueueTest {
	static DelayQueue<MyClass> dq = new DelayQueue<>();
	public static void main(String[] args) throws InterruptedException {
		MyClass mc1 = new MyClass(1);
		
		dq.put(mc1);
		dq.put(new MyClass(5));
		dq.put(new MyClass(2));
		System.out.println(dq);
		dq.take();
		System.out.println(new Date());
		dq.take();
		System.out.println(new Date());
		dq.take();
		System.out.println(new Date());
		
	}
	
	static class MyClass implements Delayed{
		public int number;
		
		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}

		public MyClass(int number) {
			super();
			this.number = number;
		}

		@Override
		public int compareTo(Delayed o) {
			MyClass mc = null;
			if(o instanceof MyClass) {
				mc = (MyClass)o;
			}else {
				return 0;
			}
			return this.getNumber() > mc.getNumber()?1:(this.getNumber() < mc.getNumber()?-1:0);
		}

		@Override
		public long getDelay(TimeUnit unit) {
			return 5;
		}

		@Override
		public String toString() {
			return "MyClass [number=" + number + "]";
		}
		
	}
}
