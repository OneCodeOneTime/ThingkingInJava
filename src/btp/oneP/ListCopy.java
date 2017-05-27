package btp.oneP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListCopy {
	
	public static <T> void copy(List<? extends T> src,List<? super T> dest){
		for(T t:src){
			dest.add(t);
		}
	}
	
	public static void main(String[] args) {
		List<String> sList = new ArrayList<String>(Arrays.<String>asList(new String[]{"hehe","xixi","caca"}));
		List<Object> oList = new ArrayList<Object>();
		copy(sList,oList);
		for(Object o:oList){
			System.out.println(o);
		}
	}

}
