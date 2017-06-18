package btp.oneP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FillingLists {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		List<StringAddress> list = (List) Collections.nCopies(4, new StringAddress("hehe"));
		System.out.println(list);
		list = new ArrayList<StringAddress>(list);
		System.out.println(list);
		
		Collections.fill(list, new StringAddress("xixi"));
		System.out.println(list);
	}

}

class StringAddress{
	private String s;
	public StringAddress(String s){
		this.s = s;
	}
	public String toString(){
		return super.toString()+" "+s;
	}
}
