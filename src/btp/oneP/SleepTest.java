package btp.oneP;

public class SleepTest {

	public static void main(String[] args) throws InterruptedException {
		Object o = new Object();
		Thread t1 = new Thread(new ST1(o));
		Thread t2 = new Thread(new ST2(o));
		t1.start();
		Thread.sleep(4000);
		t2.start();
		Thread.sleep(20000);
	}

}

class ST1 implements Runnable{
	private Object o;
	public ST1(Object o) {
		this.o = o;
	}
	@Override
	public void run() {
		System.out.println("ST1 get CPU...");
		synchronized(o) {
			System.out.println("ST1获得锁...");
			try {
				Thread.sleep(10000L);
				System.out.println("ST1 after sleep and get CPU");
			} catch (InterruptedException e) {
				System.out.println("ST1被中断...");
			}
			System.out.println("ST1准备释放锁...");
		}
		System.out.println("ST1 realease CPU...");
	}
	
}

class ST2 implements Runnable{
	private Object o;
	public ST2(Object o) {
		this.o = o;
	}
	@Override
	public void run() {
		System.out.println("ST2 get CPU...");
		synchronized(o) {
			System.out.println("ST2获得锁...");
		}
		System.out.println("ST2 realease CPU...");
	}
	
}


/**
 * 使当前的线程停止millis毫秒的时间。
 * 线程调用sleep(millis)并不会失去锁的持有权。
 *
 * @param  millis
 *         线程停止执行的毫秒数
 *
 * @throws  IllegalArgumentException
 *          millis为负数
 *
 * @throws  InterruptedException
 * 			如果线程被其他线程中断，则线程的中断状态会被清除并抛出此异常。
 */
/*public static native void sleep(long millis) throws InterruptedException;*/
