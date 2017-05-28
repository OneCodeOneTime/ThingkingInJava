package btp.oneP;

public class Wildcards {
	static void rawArgs(Holder holder,Object arg){
		holder.set(arg);
		//holder.set(new Wildcards());
		Object ob = holder.get();
		System.out.println("rawArgs:"+ob.getClass().getName());
	}
	
	static void unboundedArg(Holder<?> holder,Object arg){
		holder.set(null);
		Object ob = holder.get();
		System.out.println("unboundedArg:"+ob);
	}
	
	
	static <T> T exact1(Holder<T> holder){
		T t = holder.get();
		return t;
	}
	static <T> T exact2(Holder<T> holder,T arg){
		holder.set(arg);
		T t = holder.get();
		return t;
	}
	
	static <T> T wildSubtype(Holder<? extends T> holder,T arg){
		holder.set(null);
		T t = holder.get();
		return t;
	}
	
	static <T> void wildSupertype(Holder<? super T> holder,T arg){
		holder.set(arg);
		Object ob = holder.get();
		System.out.println("wildSupertype:"+ob);
	}
	public static void main(String[] args) {
		Holder raw = new Holder<Long>();
		raw = new Holder();
		
		Holder<Long> qualified = new Holder<Long>();
		Holder<?> unbounded = new Holder<Long>();
		Holder<? extends Long> bounded = new Holder<Long>();
		Long lng = 1L;
		rawArgs(raw,lng);
		rawArgs(qualified,lng);
		rawArgs(unbounded,lng);
		rawArgs(bounded,lng);
		
		/*unboundedArg(raw,lng);
		unboundedArg(qualified,lng);
		unboundedArg(unbounded,lng);
		unboundedArg(bounded,lng);*/
		
		Object r1 = exact1(raw);
		System.out.println(r1);
		Long r2 = exact1(qualified);
		System.out.println(r2);
		Object r3 = exact1(unbounded);
		System.out.println(r3);
		Long r4 = exact1(bounded);
		System.out.println(r4);
		
		Long r5 = exact2(raw,lng);
		Long r6 = exact2(qualified,lng);
		//Long r7 = exact2(unbounded,lng);
		//Long r8 = exact2(bounded,lng);
		
		Long r9 = wildSubtype(raw,lng);
		Long r10 = wildSubtype(qualified,lng);
		Object r11 = wildSubtype(unbounded,lng);
		Long r12 = wildSubtype(bounded,lng);
		
		wildSupertype(raw,lng);
		wildSupertype(qualified,lng);
		//wildSupertype(unbounded,lng);
		//wildSupertype(bounded,lng);
	}

}
