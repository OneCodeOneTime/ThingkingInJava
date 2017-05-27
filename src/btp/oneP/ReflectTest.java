package btp.oneP;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest {

	public static void main(String[] args) {
		/*Integer i =new Integer(0);
		i.getClass();
		Class<Integer> ic = (Class<Integer>) new Integer(5).getClass();
		Method[] methods = ic.getMethods();
		Constructor<?>[] cs = ic.getConstructors();		
		for(Method m:methods){
			System.out.println(m);
		}
		for(Constructor c:cs){
			System.out.println(c);
		}*/
		Class<?> rc = RefelectTest.class;
		Method[] methods = rc.getMethods();
		Constructor<?>[] cs = rc.getConstructors();		
		for(Method m:methods){
			System.out.println(m);
		}
		System.out.println("------------");
		for(Constructor c:cs){
			System.out.println(c);
		}
	}

}

class RefelectTest{
	
}
