package btp.oneP;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class AQSTest {

	public static void main(String[] args) {
		AbstractQueuedSynchronizer aqs = null;
		AtomicInteger ai = null;
		Semaphore sp = null;
		CountDownLatch cd = null;
		ReentrantLock lock = null;
		ReadWriteLock  rwl = null;
		ReentrantReadWriteLock rwls = null;
	}

}
