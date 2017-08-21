package btp.oneP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class CollectionSort {

	public static void main(String[] args) {
		Collections.sort(new ArrayList<Integer>(Arrays.asList(1,2,3,4,5)), new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 > 02 ? -1 : 1;
			}
			
		});
		
	}

}
