package btp.oneP;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Fill2Test {

	public static void main(String[] args) {
		List<Contract> carrier = new ArrayList<Contract>();
		Fill2.fill(new AddableCollectionAdapter<Contract>(carrier), Contract.class, 3);
		Fill2.fill(Adapter.collectionAdapter(carrier), Contract.class, 2);
		System.out.println(carrier);
	}

}

interface Addable<T>{
	void add(T t);
}

class Fill2{
	public static <T> void fill(Addable<T> addable,Class<? extends T> classToken,int size){
		for(int i=0;i<size;i++){
			try{
				addable.add(classToken.newInstance());
			}catch(Exception e){
				throw new RuntimeException();
			}
		}
	}
	
}

class AddableCollectionAdapter<T> implements Addable<T>{
	private Collection<T> c;
	public AddableCollectionAdapter(Collection<T> c){
		this.c = c;
	}
	@Override
	public void add(T t) {
		c.add(t);
	}
	
}

class Adapter{
	public static <T> Addable<T> collectionAdapter(Collection<T> c){
		return new AddableCollectionAdapter<T>(c);
	}
}

class AddableSimpleQueue<T> extends SimpleQueue<T> implements Addable<T>{
	public void add(T t){
		super.add(t);
	}
}
