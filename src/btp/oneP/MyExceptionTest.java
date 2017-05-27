package btp.oneP;

public class MyExceptionTest {
	
	static void f() throws MyException{
		System.out.println("f()");
		throw new MyException();
	}
	
	static void g() throws MyException{
		System.out.println("g()");
		throw new MyException("Exception in g()");
	}
	public static void main (String[] args) throws MyException{
		// TODO Auto-generated method stub
		try{
			f();
		}catch(MyException e){
			System.out.println(e.getMessage());
			e.printStackTrace(System.err);
			
			//throw e;
		}
		
		try{
			g();
		}catch(MyException e){
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			e.printStackTrace(System.err);
		}
	}

}

class MyException extends Exception{
	public MyException(){}
	public MyException(String s){
		super(s);
	}
}
