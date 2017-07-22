package btp.oneP;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TypesForSets {
	static <T> Set<T> fill(Set<T> set,Class<T> type){
		try{
			for(int i=0;i<10;i++){
				set.add(type.getConstructor(int.class).newInstance(i));
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return set;
	}
	
	static <T> void test(Set<T> set,Class<T> type){
		fill(set,type);fill(set,type);fill(set,type);
		System.out.println(set);
	}
	public static void main(String[] args) {
		test(new HashSet<HashType>(),HashType.class);
		test(new LinkedHashSet<HashType>(),HashType.class);
		test(new TreeSet<TreeType>(),TreeType.class);
		test(new HashSet<SetType>(),SetType.class);
		test(new HashSet<TreeType>(),TreeType.class);
		test(new LinkedHashSet<SetType>(),SetType.class);
		test(new LinkedHashSet<TreeType>(),TreeType.class);
		try{
			test(new TreeSet<SetType>(),SetType.class);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try{
			test(new TreeSet<HashType>(),HashType.class);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}

class SetType{
	int i;
	public SetType(int n){
		i = n;
	}
	public boolean equals(Object o){
		return o instanceof SetType && (i == ((SetType)o).i);
	}
	public String toString(){
		return Integer.toString(i);
	}
}

class HashType extends SetType{

	public HashType(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}
	
	public int hashCode(){
		return i;
	}
}

class  TreeType extends SetType implements Comparable<TreeType>{

	public TreeType(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compareTo(TreeType o) {
		// TODO Auto-generated method stub
		return (o.i<i?-1:(o.i == i ? 0 : 1));
	}
	
}
