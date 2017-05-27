package btp.oneP;

public class ArrayOfGeneric {
	static final int size=100;
	static Generic<Integer>[] gia;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		//gia = (Generic<Integer>[])new Object[size];
		gia = (Generic<Integer>[])new Generic[size];
		System.out.println(gia.getClass().getSimpleName());
		gia[0] = new Generic<Integer>();
		//gia[1] = new Generic<Double>();
		System.out.println(gia[0]);
	}
	
	

}

class Generic<T>{}


