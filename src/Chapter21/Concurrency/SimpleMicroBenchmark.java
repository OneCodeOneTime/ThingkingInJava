package Chapter21.Concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleMicroBenchmark {
	static long test(Incrementable incr) {
		long start = System.nanoTime();
		for(int i = 0;i<10000000L;i++) {
			incr.increment();
		}
		return System.nanoTime() - start;
	}
	public static void main(String[] args) {
		long synchTime = test(new SynchronizingTest());
		long lockTime = test(new LockingTest());
		System.out.println("synchronized:"+synchTime);
		System.out.println("lockTime:"+lockTime);
		System.out.println("synchTime/lockTime"+synchTime/lockTime);
	}

}

abstract class Incrementable{
	protected long counter = 0;
	public abstract void increment();
}
class SynchronizingTest extends Incrementable{
	public synchronized void increment() {
		++counter;
	}
}

class LockingTest extends Incrementable{
	private Lock lock = new ReentrantLock();

	@Override
	public void increment() {
		lock.lock();
		try {
			++counter;
		}finally {
			lock.unlock();
		}
	}
	
}
