package btp.oneP;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class GenericArrayTest {

	public static void main(String[] args) {
		List<?>[] las = new List<?>[10];
		Object o = las;
		Object[] oa = (Object[])o;
		List<Integer> li = new ArrayList<Integer>();
		li.add(new Integer(3));
		oa[0] = li;
		System.out.println(las[0].get(0));
		
		List<String>[] ls = (List<String>[])new ArrayList[10];
		ls[0] = new ArrayList<String>();
		ls[0].add("sss");
		System.out.println(ls[0].get(0));
		
		Object an = Array.newInstance(ArrayList.class, 3);
	}

}
