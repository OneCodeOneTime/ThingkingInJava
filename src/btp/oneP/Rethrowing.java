package btp.oneP;

public class Rethrowing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			g();
		}catch(Exception e){
			System.out.println("main:printStackTrace()");
			e.printStackTrace(System.out);
		}
		
		try{
			h();
		}catch(Exception e){
			System.out.println("main:printStackTrace()");
			e.printStackTrace(System.out);
		}
	}
	
	public static void f() throws Exception{
		System.out.println("originating the exception in f()");
		throw new Exception("throw from f()");
	}
	public static void g() throws Exception{
		try{
			f();
		}catch(Exception e){
			System.out.println("Inside g(),e.printStackTrace()");
			e.printStackTrace(System.out);
			throw e;
		}
	}
	public static void h() throws Exception{
		try{
			f();
		}catch(Exception e){
			System.out.println("Inside h(),e.printStackTrace()");
			e.printStackTrace(System.out);
			throw (Exception)e.fillInStackTrace();
		}
	}
	

}
