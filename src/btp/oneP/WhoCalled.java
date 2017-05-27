package btp.oneP;

public class WhoCalled {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			f();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("----------------------");
		try {
			g();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("----------------------");
		try {
			h();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("----------------------");
	}
	static void f() throws Throwable{
		try{
			throw new NullPointerException();
		}catch(Exception e){
			throw e.fillInStackTrace();
		}
	}
	
	static void g() throws Throwable{try {
		f();
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.fillInStackTrace();
	}}
	static void h() throws Throwable{try {
		g();
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.fillInStackTrace();
	}}

}
