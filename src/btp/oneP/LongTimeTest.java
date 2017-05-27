package btp.oneP;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public class LongTimeTest {

	public static void main(String[] args) {
		LinkedList<Integer> ll=new LinkedList<Integer>(Arrays.asList());
		ListIterator<Integer> il=ll.listIterator(ll.size()/2);
		for(int i=0;i<10;i++){
			il.add(i);
			System.out.println(ll);
			il=ll.listIterator(ll.size()/2);
		}
		
	}

}

class Snow{public String toString(){return "Snow";}}
class Powder extends Snow{public String toString(){return "Powder";}}
class Light extends Powder{public String toString(){return "Light";}}
class Heavy extends Powder{public String toString(){return "Heavy";}}
class Crusty extends Snow{public String toString(){return "Crusty";}}
class Slush extends Snow{public String toString(){return "Slush";}}


