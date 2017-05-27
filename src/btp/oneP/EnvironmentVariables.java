package btp.oneP;

import java.util.Arrays;
import java.util.Iterator;

public class EnvironmentVariables {

	public static void main(String[] args) {
//		for(Map.Entry<String, String> entry:System.getenv().entrySet()){
//			System.out.println(entry.getKey()+":"+entry.getValue());
//		}
		String[] s=new String[]{"a","b","c","d","e"};
		test(Arrays.asList(s));
		
	}
	
	static <T> void test(Iterable<T> ib){
		for(T t:ib){
			System.out.println(t);
		}
	}

}
