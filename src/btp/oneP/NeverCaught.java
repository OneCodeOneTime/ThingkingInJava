package btp.oneP;

public class NeverCaught {

	public static void main(String[] args){
		g();

	}

	private static void g(){
		f();
	}

	private static void f(){
		throw new NullPointerException("From f()");
	}

}

class MyExceptionNew extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyExceptionNew(String string) {
		super(string);
	}
	
}
