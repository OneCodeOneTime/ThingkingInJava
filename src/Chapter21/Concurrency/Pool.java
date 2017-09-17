package Chapter21.Concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Pool<T>{
	private int size;
	private List<T> items = new ArrayList<T>();
	private volatile boolean[] checkedOut;
	private Semaphore available;
	public Pool(Class<T> classObject,int size) {
		this.size = size;
		//初始为false
		checkedOut = new boolean[size];
		available = new Semaphore(size,true);
		for(int i=0;i<size;i++) {
			try {
				items.add(classObject.newInstance());
			}catch(Exception e) {
				throw new RuntimeException();
			}
		}
	}
	
	public T checkOut() throws InterruptedException {
		available.acquire();
		return getItem();
	}
	
	public void checkIn(T x) {
		if(releaseItem(x)) {
			available.release();
		}
	}
	
	//获取池中为false的对象
	private synchronized T getItem() {
		for(int i=0;i<size;i++) {
			if(!checkedOut[i]) {
				checkedOut[i] = true;
				return items.get(i);
			}
		}
		return null;
	}
	private synchronized boolean releaseItem(T item) {
		int index = items.indexOf(item);
		if(index == -1) {
			return false;
		}
		//true的说明是已经被用的
		if(checkedOut[index]) {
			checkedOut[index] = false;
			return true;
		}
		return false;
	}
}
