package btp.oneP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ArraysAsListTest {

	public static void main(String[] args) {
		String[] ss=new String[]{"Jordan","Kobe","James","Durant","cury"};
		List<String> cs=Arrays.asList(ss);
		Collections.shuffle(cs, new Random(47));
		System.out.println(cs);
		System.out.println(Arrays.toString(ss));
		
		List<String> cs2=new ArrayList<String>(cs);
		Collections.shuffle(cs2, new Random(47));
		System.out.println(cs2);
		System.out.println(cs);
	}

}
