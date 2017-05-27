package btp.oneP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class SeveralItrerableTest {

	public static void main(String[] args) {
		RevisibleArrayList<String> ra = new RevisibleArrayList<String>(Arrays.asList("jordan","kobe","james","durant","kuru"));
		for(String s:ra.revisible()){
			System.out.print(s+" ");
		}
		System.out.println();
		for(String s:ra){
			System.out.print(s+" ");
		}
	}

}

class RevisibleArrayList<T> extends ArrayList<T>{
	public RevisibleArrayList(Collection<? extends T> c){
		super(c);
	}
	public Iterable<T> revisible(){
		return new Iterable<T>(){

			@Override
			public Iterator<T> iterator() {
				// TODO Auto-generated method stub
				return new Iterator<T>(){
					int index=size()-1;
					@Override
					public boolean hasNext() {
						// TODO Auto-generated method stub
						return index>-1;
					}

					@Override
					public T next() {
						if(hasNext()){
							return get(index--);
						}
						return null;
					}
				};
			}
		 
		};
	}
}