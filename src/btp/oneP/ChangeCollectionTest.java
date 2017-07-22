package btp.oneP;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChangeCollectionTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("hh");
		Iterator<String> it = list.iterator();
		//list.add("hh");
		while(it.hasNext()){
			it.remove();
		}
	}

}
