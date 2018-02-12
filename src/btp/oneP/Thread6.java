package btp.oneP;

public class Thread6 {
	public static void main(String...args) throws InterruptedException {
		Object o = new Object();
		/*创建6个线程，1个ET1和5个ET2*/
		ET1 et1 = new ET1(o);
		Thread t1 = new Thread(et1);
		Thread t2_1 = new Thread(new ET2(o,et1));
		Thread t2_2 = new Thread(new ET2(o,et1));
		Thread t2_3 = new Thread(new ET2(o,et1));
		Thread t2_4 = new Thread(new ET2(o,et1));
		Thread t2_5 = new Thread(new ET2(o,et1));
		//先让t1执行
		t1.start();
		Thread.sleep(5000);
		t2_1.start();t2_2.start();t2_3.start();t2_4.start();t2_5.start();
		t1.interrupt();
		//五个线程中会有一个线程会先获得锁，这个线程执行完会唤醒wait的t1并且将其休眠条件置为true，让t1和剩下的四个线程一起竞争锁。
		Thread.sleep(20000);
	}
}

class ET1 implements Runnable{
	//线程的休眠条件，只要condition为false，线程就要休眠
	private boolean condition;
	
	/**
	 * 锁对象
	 */
	Object o;
	public ET1(Object o) {
		this.o = o;
	}
	@Override
	public void run() {
		synchronized(o) {
			System.out.println("ET1获得锁...");
			try {
				//防止虚假唤醒（虚假唤醒的时候condition不一定满足），所以重复检查条件
				while(!condition) {
					o.wait();	
				}
				
				System.out.println("ET1 after wait...");
			} catch (InterruptedException e) {
				System.out.println("ET1被中断...");
				//被中断也要检查条件，不满足也要继续休眠
				while(!condition) {
					try {
						System.out.println("ET1被中断但是条件不满足，继续休眠...");
						o.wait();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				}
			}
		}
		System.out.println("ET1执行完毕释放锁...");
	}
	public boolean isCondition() {
		return condition;
	}
	public void setCondition(boolean condition) {
		this.condition = condition;
	}
	
}

class ET2 implements Runnable{
	public static int count = 0;
	private int no;
	private ET1 et1;
	
	/**
	 * 锁对象
	 */
	Object o;
	public ET2(Object o,ET1 et1) {
		this.o = o;
		this.et1 = et1;
		this.no = count++;
	}
	@Override
	public void run() {
		System.out.println(this+"等待获得对象锁...");
		synchronized(o) {
			System.out.println(this+"获得对象锁...");
			o.notify();
			//设置et1的条件为true，这样et1就不会进入休眠
			et1.setCondition(true);
			System.out.println(this+"释放锁");
		}
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	@Override
	public String toString() {
		return "ET2 [no=" + no + "]";
	}
}