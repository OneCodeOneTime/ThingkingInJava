package btp.oneP;

public class Thread3 extends Thread {
	public void run() {
		while(true) {
			if(Thread.currentThread().isInterrupted()) {
				System.out.println("Someone interrupted me");
				break;
			}else {
				System.out.println("Thread is going...");
				
			}
		}
	}
	
	public static void main(String...args) throws InterruptedException {
		Thread3 t = new Thread3();
		t.start();
		Thread.currentThread().sleep(3000);
		t.interrupt();
	}
	
	/**
     * 如果没有其它线程调用对象锁的Object#notify()或者Object#notifyAll()方法，那调用了同一个
     * 对象锁的Object#wait()方法的线程会一直等待。
     * 调用Object#wait()和调用Object#wait(0)效果是一样的。
     * 调用wait()方法必须先获得对象锁。wait()方法的作用是释放当前拥有的对象锁并一直等待，
     * 直到有其它线程使用同一个对象锁调用notify()方法或notifyAll()方法才可能继续执行wait()
     * 之后的代码。
     * 有一种说法认为，执行wait()方法之后，可能会有中断或者虚假的唤醒，所以wait()方法一
     * 般要放在一个循环中（一般wait()方法的调用是伴随一个条件的，条件发生时才调用wait()，
     * 中断或者虚假唤醒可能发生在这个条件满足的情况下，所以如果中断或者虚假唤醒了，要重
     * 新检查这个条件是否满足，满足的话就重新调用wait()）：
     *     synchronized (obj) {
     *         while (&lt;condition does not hold&gt;)
     *             obj.wait();
     *         ... // Perform action appropriate to condition
     *     }
     * 切记，wait()方法必须被拥有对象锁的线程调用。可以查看notify()方法来了解线程获得对象
     * 锁的多种方式。
     *
     * @throws  IllegalMonitorStateException  调用wait()方法的线程没有拥有
     *               对象锁。
     * @throws  InterruptedException 线程在调用wait()方法之前或wait()方法等待中
     *             被其他线程中断了，就会抛出这个异常并重置中断状态位。
     * @see        java.lang.Object#notify()
     * @see        java.lang.Object#notifyAll()
     */
   /* public final void wait() throws InterruptedException {
        wait(0);
    }*/
	
	/**
     * 如果没有其它线程调用对象锁的Object#notify()或者Object#notifyAll()方法，那调用了同一个
     * 对象锁的Object#wait(timeout)方法的线程会一直等待；timeout长的时间过后同样会停止等待。
     * 调用wait(timeout)方法的线程必须现获得对象锁。
     * 这个方法会把调用它的线程放入对象锁的等待集合中，并且唤醒在这个对象锁上等待的对象。线程会停止执行余下的
     * 代码并陷入休眠。直到下面四个条件发生其一：
     * ①有线程调用了这个对象锁的notify()方法，并且刚好是休眠线程被选中唤醒。
     * ②有线程调用了这个对象锁的notifyAll()方法。
     * ③有线程调用了休眠线程的interrupt()方法。
     * ④过去了参数timeout长的时间。如果timeout是0，那线程会一直等待，wait(0)和wait()效果一样。
     * 上面四个条件有一个发生了，那休眠线程就会从对象锁的等待集合中移去，它会和其它等待对象锁上的线程一起
     * 竞争这个对象锁的使用权。一旦它获得了锁，它就会被恢复为wait(timeout)前的状态，当过去timeout长的
     * 时间也一样。线程会继续执行wait(timeout)之后的代码。
     * 
     * 除了被notify()/notifyAll()方法、中断和超时唤醒以外，线程也会被所谓的虚假唤醒。虽然这种情况在现实中
     * 很少发生，但是程序必须检查线程被唤醒的条件是否满足，如果不满足就应该继续让程序休眠。所以wait(timeout)
     * 方法最好在一个循环中被调用，这样的话，线程被唤醒也可以检查条件是否满足：
     *     synchronized (obj) {
     *         while (&lt;condition does not hold&gt;)
     *             obj.wait(timeout);
     *         ... // Perform action appropriate to condition
     *     }
     *	如果线程被java.lang.Thread#interrupt()中断之后调用wait(timeout)或者调用wait(timeout)休眠中被
     *  java.lang.Thread#interrupt()中断，就会抛出InterruptedException。这个异常在对象
     *  锁被重置的时候抛出。
     *
     * wait方法只能用于解除当前对象锁；其它可以同步当前线程的对象在线程休眠时依然可以处于锁定状态。
     * 切记，wait(timeout)方法必须被拥有对象锁的线程调用。可以查看notify()方法来了解线程获得对象
     * 锁的多种方式。
     *
     * @param      timeout   等待的最大时间数。
     * @throws  IllegalArgumentException      当timeout为负数。
     * @throws  IllegalMonitorStateException  当调用wait(timeout)方法的线程没有获得对象锁。
     * @throws  InterruptedException 如果线程被java.lang.Thread#interrupt()中断之后
     * 									调用wait(timeout)或者调用wait(timeout)休眠中被
     *  								java.lang.Thread#interrupt()中断抛出此异常，
     *  								并且重置线程的中断状态。
     * @see        java.lang.Object#notify()
     * @see        java.lang.Object#notifyAll()
     */
   /* public final native void wait(long timeout) throws InterruptedException;*/
	
	
	/**
	 * 唤醒一个在对象锁上休眠的线程，如果有多个休眠的线程，任意唤醒其中一个。在对象锁上休眠的线程指的是
	 * 调用了对象锁的wait方法（三个wait方法中的任意一个）的线程。
	 * 被唤醒的线程只有在当前线程放弃对象锁之后才可能继续执行，被唤醒的线程会和其它等待锁的线程（等待执行synchronized）
	 * 一起竞争对象锁的拥有权，竞争是公平的，不会有特权也不会有劣势。
	 * 此方法必须在拥有对象锁的前提下执行，线程获得对象锁的方式有三种：
     * ①执行对象锁的同步方法
     * ②执行对象锁的同步代码块。
     * ③如果对象锁是Class类型，执行此类的静态方法。
     * 一个对象锁某一时刻只能被一个线程持有。
     *
     * @throws  IllegalMonitorStateException  当调用notify()方法的线程不是对象锁的拥有者。
     * @see        java.lang.Object#notifyAll()
     * @see        java.lang.Object#wait()
     */
    /*public final native void notify();*/
	
	 /**
     * 唤醒所有在对象锁上休眠的线程。在对象锁上休眠的线程指的是
	 * 调用了对象锁的wait方法（三个wait方法中的任意一个）的线程。
	 * 被唤醒的线程只有在当前线程放弃对象锁之后才可能继续执行，被唤醒的线程会和其它等待锁的线程（等待执行synchronized）
	 * 一起竞争对象锁的拥有权，竞争是公平的，不会有特权也不会有劣势。
     * 此方法必须在拥有对象锁的前提下执行，线程获得对象锁的方式间Object#notify()方法。
     *
     * @throws  IllegalMonitorStateException  当调用notify()方法的线程不是对象锁的拥有者。
     * @see        java.lang.Object#notify()
     * @see        java.lang.Object#wait()
     */
    /*public final native void notifyAll();*/
}
