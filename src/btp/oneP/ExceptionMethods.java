package btp.oneP;

public class ExceptionMethods {

	public static void main(String[] args) throws Throwable {
		try{
			throw new ArithmeticException();
		}catch(Exception e){
//			System.out.println(e.getClass());
//			System.out.println(e.getMessage());
//			System.out.println(e.getLocalizedMessage());
//			System.out.println();
//			System.out.println(e);
//			e.printStackTrace();
			StackTraceElement[] exs = e.getStackTrace();
			for(StackTraceElement ste:exs){
				System.out.println(ste.toString());
			}
			
		}

	}

}
