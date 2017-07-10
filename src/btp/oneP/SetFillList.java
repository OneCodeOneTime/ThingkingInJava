package btp.oneP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetFillList {

	public static void main(String[] args) {
		List<String> c = Collections.nCopies(5, new String("hello"));
		Set<String> s = new HashSet<String>(c);
		System.out.println(s);
		List<String> l = new ArrayList<String>(s);
		System.out.println(l);
		Collections.fill(l, new String("world"));
		s = new HashSet<String>(l);
		System.out.println(s);
	}

}
