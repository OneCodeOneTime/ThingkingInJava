package btp.oneP;

import java.util.ArrayList;
import java.util.List;

public class SuperExtendsTest {
	public static void main(String...args){
		List<? super Son> list1 = new ArrayList<Son>();
		list1.add(new Sunzi());
		List<? extends Son> son = new ArrayList<Sunzi>();
		List<? extends Baba> baba = son;
		System.out.println(baba.getClass().getName());
	}
}

class Baba{}
class Son extends Baba{}
class Sunzi extends Son{}

