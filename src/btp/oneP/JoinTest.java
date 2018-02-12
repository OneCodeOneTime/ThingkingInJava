package btp.oneP;

public class JoinTest {

	public static void main(String[] args) throws InterruptedException {
		Thread jt2 = new Thread(new JT2());
		Thread jt1 = new Thread(new JT1(jt2));
		
		jt2.start();
		Thread.sleep(3000);
		jt1.start();
		//jt1.interrupt();此时jt1没必要等jt2完成再继续
		Thread.sleep(20000);
	}

}


class JT1 implements Runnable {
	private Thread t;
	public JT1(Thread t) {
		this.t= t;
	}
	
	@Override
	public void run() {
		System.out.println("JT1 executing...");
		try {
			//t.join();
			//t.join(1000L);
			t.join(0, 0);
			System.out.println("JT1 after JT2 join...");
		} catch (InterruptedException e) {
			//Thread.currentThread().interrupt();
			System.out.println("JT1 interrupted...");
		}
		
	}
	
}

class JT2 implements Runnable{

	@Override
	public void run() {
		/*while(true) {//这样的话ST1就永远不会继续往下执行了}*/
		System.out.println("JT2 executing...");
		try {
			Thread.sleep(10000);
			System.out.println("JT2 after sleep...");
		} catch (InterruptedException e) {
			System.out.println("JT2 interrupted...");
			//Thread.currentThread().interrupt();
		}
	}
	
}


/**
 * 等待调用join()方法的线程死亡，当前线程才继续往下运行。
 * 比如在线程t1代码中调用了t2.join()，则t1要等t2死亡之后才继续执行。
 *
 * join()和join(0)效果一样。
 *
 * @throws  InterruptedException
 * 			如果线程代码中调用了join，线程被其它线程中断，会抛出此异常，且中断状态会被清除。
 * 			其实就是如果t1中代码有t2.join()，那意思就是t1等待t2先完成再继续，但是中断在
 * 			这里的意思是t1不想等t2了，就把t1中断了，t1就不必等t2完成再完成。
 */
/*public final void join() throws InterruptedException {
    join(0);
}*/


/**
 * 等待调用join(millis)方法的线程死亡millis毫秒，如果millis毫秒时间后调用线程还未死亡或者
 * millis毫秒时间内调用线程就死亡了，当前线程继续执行。
 * join(0)和join()效果一样，会一直等下去，直到调用线程死亡。
 *
 *	join(millis)使用循环检查this.isAlive()，判断调用线程是否死亡。而且join是使用wait
 *	来实现的，所以其他线程调用调用线程的notifyAll()方法就会破坏join方法，所以推荐应用程序
 *	中不要使用线程作为对象锁。
 *
 * @param  millis
 *         等待的最大时长
 *
 * @throws  IllegalArgumentException
 *          millis是负数
 *
 * @throws  InterruptedException
 *          同join()
 */
/*public final synchronized void join(long millis)
throws InterruptedException {
    long base = System.currentTimeMillis();
    long now = 0;

    if (millis < 0) {
        throw new IllegalArgumentException("timeout value is negative");
    }

    if (millis == 0) {
        while (isAlive()) {
            wait(0);
        }
    } else {
        while (isAlive()) {
            long delay = millis - now;
            if (delay <= 0) {
                break;
            }
            wait(delay);
            now = System.currentTimeMillis() - base;
        }
    }
}*/