package btp.oneP;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class MapDataTest {

	public static void main(String[] args) {
		System.out.println(MapData.map(new Letters(), 11));
		
		System.out.println(MapData.map(new Letters(), "Pop"));
	}

}


class PairN<K,V>{
	public final K key;
	public final V value;
	public PairN(K k,V v){
		this.key = k;
		this.value = v;
	}
}

class MapData<K,V> extends LinkedHashMap<K,V>{
	public MapData(GeneratorN<PairN<K,V>> gen,int quantity){
		for(int i=0;i<quantity;i++){
			PairN<K,V> p = gen.next();
			this.put(p.key, p.value);
		}
	}
	
	public MapData(GeneratorN<K> genK,GeneratorN<V> genV,int quantity){
		for(int i=0;i<quantity;i++){
			this.put(genK.next(), genV.next());
		}
	}
	
	public MapData(GeneratorN<K> genK,V value,int quantity){
		for(int i=0;i<quantity;i++){
			this.put(genK.next(), value);
		}
	}
	
	public MapData(Iterable<K> genK,GeneratorN<V> genV){
		for(K key:genK){
			this.put(key,genV.next());
		}
	}
	
	public MapData(Iterable<K> genK, V value){
		for(K key:genK){
			this.put(key, value);
		}
	}
	
	public static <K,V> MapData<K,V> map(GeneratorN<PairN<K,V>> gen,int quantity){
		return new MapData<K,V>(gen,quantity);
	}
	
	public static <K,V> MapData<K,V> map(GeneratorN<K> genK,GeneratorN<V> genV,int quantity){
		return new MapData<K,V>(genK,genV,quantity);
	}
	
	public static <K,V> MapData<K,V> map(GeneratorN<K> genK,V value,int quantity){
		return new MapData<K,V>(genK,value,quantity);
	}
	
	public static <K,V> MapData<K,V> map(Iterable<K> genK,GeneratorN<V> genV){
		return new MapData<K,V>(genK,genV);
	}
	
	public static <K,V> MapData<K,V> map(Iterable<K> genK,V value){
		return new MapData<K,V>(genK,value);
	}
}

class Letters implements GeneratorN<PairN<Integer,String>>,
	Iterable<Integer>{
	
	private int size = 9;
	private int number = 1;
	private char letter = 'A';
	
	@Override
	public PairN<Integer, String> next() {
		return new PairN<Integer,String>(number++,""+letter++);
	}

	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<Integer>(){

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return number < size;
			}

			@Override
			public Integer next() {
				// TODO Auto-generated method stub
				return number++;
			}
			
		};
	}
	
}