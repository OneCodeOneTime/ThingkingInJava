package btp.oneP;

import java.util.Iterator;

public class IteratorTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Iterator2 it = new Iterator2();
		for(String s:it){
			System.out.println(s);
		}
	}

}

class Iterator2 implements Iterable<String>{
	String[] ss=new String[]{"jordan","kobe","james","durant","kuru"};
	public Iterator<String> iterator(){
		return new Iterator<String>(){
			int index = 0;
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return index<ss.length;
			}

			@Override
			public String next() {
				if(hasNext()){
					return ss[index++];
				}
				return null;
			}
			
		};
	}
}
