package btp.oneP;

public class WaitTest {

	public static void main(String[] args) throws InterruptedException {
		Object o = new Object();
		T1 t1 = new T1(o);
		T2 t2 = new T2(o);
		T3 t3 = new T3(o);
		Thread t = new Thread(t1);
		Thread tt = new Thread(t2);
		Thread ttt = new Thread(t3);
		System.out.println(t.getState());
		t.start();
		System.out.println(t.getState());
		//tt.start();
		//ttt.start();
		//t.interrupt();
		Thread.sleep(10000);
		System.out.println(t.getState());
	}

}

class T1 implements Runnable{
	Object o;
	public T1(Object o) {
		this.o = o;
	}
	@Override
	public void run() {
			synchronized(o) {
				System.out.println("T1获得锁");
				try {
					//Thread.currentThread().interrupt();
					o.wait();
					
					//o.notify();
					System.out.println("t1 after wait");
				} catch (InterruptedException e) {
					System.out.println("*****");
					Thread.currentThread().interrupt();
				}
				System.out.println("T1----");
				o.notify();
			}
		
	}
	
}

class T2 implements Runnable{
	Object o;
	public T2(Object o) {
		this.o = o;
	}
	@Override
	public void run() {
			synchronized(o) {
				System.out.println("T2获得锁");
				try {
					o.notifyAll();
					o.wait();
					
					System.out.println("t2 after wait");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("T2----");
			}
		
		
	}
	
}

class T3 implements Runnable{
	Object o;
	public T3(Object o) {
		this.o = o;
	}
	@Override
	public void run() {
			synchronized(o) {
				System.out.println("T3获得锁");
				try {
					o.notifyAll();
					System.out.println("t3 after wait");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("T3----");
			}
		
		
	}
	
}
