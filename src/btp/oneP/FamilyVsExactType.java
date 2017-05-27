package btp.oneP;

public class FamilyVsExactType {
	
	static void test(Object o){
		System.out.println(o.getClass());
		System.out.println(o instanceof Base);
		System.out.println(o instanceof Derived);
		System.out.println(Base.class.isInstance(o));
		System.out.println(Derived.class.isInstance(o));
		System.out.println(o.getClass() == Base.class);
		System.out.println(o.getClass() == Derived.class);
		System.out.println(o.getClass().equals(Base.class));
		System.out.println(o.getClass().equals(Derived.class));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test(new Base());
		test(new Derived());
	}

}

class Base{}
class Derived extends Base{}

