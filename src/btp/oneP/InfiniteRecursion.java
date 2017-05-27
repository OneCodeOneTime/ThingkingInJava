package btp.oneP;

import java.util.ArrayList;
import java.util.List;

public class InfiniteRecursion extends Hehe {

	public static void main(String[] args) {
		List<InfiniteRecursion> list = new ArrayList<InfiniteRecursion>();
		for(int i=0;i<10;i++){
			list.add(new InfiniteRecursion());
		}
		System.out.println(list);
	}
	
	public String toString(){
		return "InfiniteRecursion: "+super.toString()+"\n";
	}

}


class Hehe{
	public String toString(){
		return "hehe";
	}
}