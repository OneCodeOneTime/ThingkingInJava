package btp.oneP;

public class ClassTest {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		//System.out.println(Integer.class == int.class);
//		Class<Integer> clazz = Integer.class;
//		System.out.println(clazz);
//		Class<? super Integer> cs = clazz.getSuperclass();
//		Object n = cs.newInstance();
//		System.out.println(n.getClass());
		
		/*Class<ChildClass> childClass = ChildClass.class;
		Class<? super ChildClass> parentClass = childClass.getSuperclass();
		Object parentObject = parentClass.newInstance();
		System.out.println(parentObject.getClass().newInstance().getClass());*/
		
		Number b =new Integer(2);
		//Integer i = Integer.class.cast(b);
		Integer i = (Integer)b;
		System.out.println(b);
		
		System.out.println(i instanceof Object);
	}

}

class ParentClass{}
class ChildClass extends ParentClass{}
