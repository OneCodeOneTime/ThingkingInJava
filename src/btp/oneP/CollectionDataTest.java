package btp.oneP;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class CollectionDataTest {

	public static void main(String[] args) {
		Set<String> set = new LinkedHashSet<String>(new CollectionData<String>(new Government(),7));
		set.addAll(CollectionData.list(new Government(), 7));
		System.out.println(set);
	}

}

class CollectionData<T> extends ArrayList<T> {
	public CollectionData(GeneratorN<T> gen,int quantity){
		for(int i=0;i<quantity;i++){
			this.add(gen.next());
		}
	}
	
	public static <T> CollectionData<T> list(GeneratorN<T> gen,int quantity){
		return new CollectionData<T>(gen,quantity);
	}
}

interface GeneratorN<T>{
	T next();
}

class Government implements GeneratorN<String>{
	String[] foundation = "you are a hero not a coward".split(" ");
	private int index;
	@Override
	public String next() {
		// TODO Auto-generated method stub
		return foundation[index++];
	}
	
}


