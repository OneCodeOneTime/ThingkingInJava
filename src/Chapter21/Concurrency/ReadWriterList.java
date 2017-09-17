package Chapter21.Concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriterList<T>{
	private ArrayList<T> lockedList;
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
	public ReadWriterList(int size,T initialValue) {
		lockedList = new ArrayList<T>(Collections.nCopies(size, initialValue));
	}
	public T set(int index,T element) {
		Lock wLock = lock.writeLock();
		wLock.lock();
		try {
			return lockedList.set(index, element);
		}finally {
			wLock.unlock();
		}
	}
	
	public T get(int index) {
		Lock rLock = lock.readLock();
		rLock.lock();
		try {
			if(lock.getReadHoldCount()>1) {
				System.out.println(lock.getReadLockCount());
			}
			return lockedList.get(index);
		}finally {
			rLock.unlock();
		}
	}
	
	
	static class ReaderWriterListTest{
		ExecutorService exec = Executors.newCachedThreadPool();
		private final static int SIZE = 100;
		private static Random rand = new Random(47);
		private ReadWriterList<Integer> list = new ReadWriterList<Integer>(SIZE,0);
		private class Writer implements Runnable{

			@Override
			public void run() {
				try {
					for(int i=0;i<20;i++) {
						list.set(i, rand.nextInt());
						TimeUnit.MICROSECONDS.sleep(100);
					}
				}catch(InterruptedException e) {
					
				}
			}
			
		}
		private class Reader implements Runnable{

			@Override
			public void run() {
				try {
					while(!Thread.interrupted()) {
						for(int i=0;i<20;i++) {
							list.get(i);
							TimeUnit.MICROSECONDS.sleep(1);
						}
					}
				}catch(InterruptedException e) {
					
				}
			}
			
		}
		
		public ReaderWriterListTest(int readers,int writers) {
			for(int i=0;i<readers;i++) {
				exec.execute(new Reader());
			}
			for(int i=0;i<writers;i++) {
				exec.execute(new Writer());
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
