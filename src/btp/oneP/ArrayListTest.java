package btp.oneP;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>(Arrays.<Integer>asList(1,2,3));
		
		list.add(3);
		Object[] obs=list.toArray();
		System.out.println(obs[0]);
	}

}
