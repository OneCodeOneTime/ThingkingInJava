package btp.oneP;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class LRU<K,V> extends LinkedHashMap<K, V> implements Map<K,V>{
	public LRU(int initialCapacity,float loadFactor,boolean accessOrder) {
       super(initialCapacity, loadFactor, accessOrder);
	}
	
	public static void main(String[] args) {
		AbstractQueuedSynchronizer aqs = null;
	}

}

abstract class KHGKJ{
	abstract void f();
}