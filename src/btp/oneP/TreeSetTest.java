package btp.oneP;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class TreeSetTest {

	public static void main(String[] args) {
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		Random rd=new Random(47);
		for(int i=0;i<1000;i++){
			Integer num=rd.nextInt(20);
			map.put(num,null==map.get(num)?1:map.get(num)+1);
		}
		Set<Entry<Integer, Integer>> emtrys=map.entrySet();
		Iterator<Entry<Integer, Integer>> i=emtrys.iterator();
		
		while(i.hasNext()){
			System.out.println(i.next().getKey()+":"+i.next().getValue());
		}
		
	}

}
