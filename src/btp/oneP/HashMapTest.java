package btp.oneP;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapTest {

	public static void main(String[] args) {
		LinkedHashMap<Integer,String> hashMap = new LinkedHashMap<>();
		hashMap.put(5, "e");
		hashMap.put(1, "a");
		hashMap.put(2, "b");
		hashMap.put(3, "c");
		hashMap.put(4, "d");
		
		for(Entry<Integer, String> entry:hashMap.entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}

}
