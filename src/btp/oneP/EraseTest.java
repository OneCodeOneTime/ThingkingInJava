package btp.oneP;

import java.util.Arrays;
import java.util.Collection;

public class EraseTest {

	public static void main(String[] args) {
		Class c = new Erase<Collection>().getClass();
		System.out.println(Arrays.toString(c.getTypeParameters()));
	}

}

class Erase<T extends Iterable>{
	
}
