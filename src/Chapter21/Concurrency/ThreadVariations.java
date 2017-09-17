package Chapter21.Concurrency;

import java.util.concurrent.TimeUnit;

public class ThreadVariations {

	public static void main(String[] args) {
		new InterThread1("InterThread1");
		new InnerThread2("InterThread2");
		new InnerRunnable1("InnerRunnable1");
		new InnerRunnable2("InnerRunnable2");
		new ThreadMethod("ThreadMethod").runTask();
	}

}


class InterThread1{
	private int countDown = 5;
	private Inner inner;
	private class Inner extends Thread{
		Inner(String name){
			super(name);
			start();
		}
		public void run() {
			try {
				while(true) {
					System.out.println(this);
					if(--countDown == 0) {
						return;
					}
					sleep(10);
				}
			}catch(InterruptedException e) {
				System.out.println("interrupted");
			}
		}
		
		public String toString() {
			return getName()+":"+countDown+"; ";
		}
		
	}
	public InterThread1(String name) {
		inner = new Inner(name);
	}
}

class InnerThread2{
	private int countDown = 5;
	private Thread t;
	public InnerThread2(String name) {
		t = new Thread(name) {
			public void run() {
				try {
					while(true) {
						System.out.println(this);
						if(--countDown == 0) {
							return;
						}
						sleep(10);
					}
				}catch(InterruptedException e) {
					System.out.print("sleep() interrupted");
				}
			}
			public String toString() {
				return getName()+":"+countDown+"; ";
			}
		};
		t.start();
	}
}

class InnerRunnable1{
	private int countDown = 5;
	private Inner inner;
	private class Inner implements Runnable{
		Thread t;
		Inner(String name){
			t = new Thread(this,name);
			t.start();
		}
		@Override
		public void run() {
			while(true) {
				
				try {
					System.out.println(this);
					if(--countDown == 0) {
						return;
					}
					TimeUnit.MICROSECONDS.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		public String toString() {
			return t.getName()+":"+countDown+"; ";
		}
	}
	public InnerRunnable1(String name) {
		inner = new Inner(name);
	}
}

class InnerRunnable2{
	private int countDown = 5;
	private Thread t;
	public InnerRunnable2(String name) {
		t =  new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					while(true) {
						System.out.println(this);
						if(--countDown == 0) {
							return;
						}
						TimeUnit.MICROSECONDS.sleep(10);
						}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			public String toString() {
				return t.getName()+":"+countDown+"; ";
			}
		},name);
		t.start();
	}
}

class ThreadMethod{
	private int countDown = 5;
	private Thread t;
	private String name;
	public ThreadMethod(String name) {
		this.name = name;
	}
	public void runTask() {
		if(null == t) {
			t = new Thread(name) {
				public void run() {
					try {
						while(true) {
							System.out.println(this);
							if(--countDown == 0) {
								return;
							}
							sleep(10);
							}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				public String toString() {
					return getName()+":"+countDown+"; ";
				}
			};
		}
		t.start();
	}
}
