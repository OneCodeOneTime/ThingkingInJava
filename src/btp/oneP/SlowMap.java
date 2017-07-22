package btp.oneP;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SlowMap<K,V> extends AbstractMap<K,V>{
	private List<K> keys = new ArrayList<K>();
	private List<V> values = new ArrayList<V>();
	public V put(K key,V value){
		V oldValue = get(key);
		if(!keys.contains(key)){
			keys.add(key);
			values.add(value);
		}else{
			values.set(keys.indexOf(key), value);
		}
		return oldValue;
	}
	
	public V get(Object key){
		if(!keys.contains(key)){
			return null;
		}else{
			return values.get(keys.indexOf(key));
		}
	}
	
	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K,V>>();
		Iterator<K> ki = keys.iterator();
		Iterator<V> vi = values.iterator();
		while(ki.hasNext()){
			set.add(new Map.Entry<K, V>() {
				K k = ki.next();
				V v = vi.next();
				@Override
				public K getKey() {
					// TODO Auto-generated method stub
					return k;
				}

				@Override
				public V getValue() {
					// TODO Auto-generated method stub
					return v;
				}

				@Override
				public V setValue(V value) {
					v = value;
					return v;
				}
				
				public String toString(){
					return k+"="+v;
				}
			});
		}
		return set;
	}
	
	public static void main(String...args){
		SlowMap<String,String> m = new SlowMap<String,String>();
		m.putAll(Countries.capitals());
		System.out.println(m);
		System.out.println(m.get("Japan"));
		//不按插入顺序打印，set
		System.out.println(m.entrySet());
	}
	
}
