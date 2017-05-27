package btp.oneP;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Generator {
	public static <T> Collection<T> fill(Collection<T> coll,int len){
		System.out.println("Collection<T>");
		for(int i=0;i<len;i++){
			coll.add(null);
		}
		return coll;
	}
	public static <T> List<T> fill(List<T> coll,int len){
		System.out.println("List<T>");
		for(int i=0;i<len;i++){
			coll.add(null);
		}
		return coll;
	}
	public static <T> ArrayList<T> fill(ArrayList<T> coll,int len){
		System.out.println("ArrayList<T>");
		for(int i=0;i<len;i++){
			coll.add(null);
		}
		return coll;
	}
	public static void main(String[] args) {
		Collection<String> c= fill(new ArrayList<String>(),4);
		System.out.println(c);
	}

}
