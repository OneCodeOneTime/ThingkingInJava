package btp.oneP;

public class CauseException {

	public static void main(String[] args) throws TwoException {
		// TODO Auto-generated method stub
		f();
	}
	
	public static void f() throws TwoException{
		try{
			g();
		}catch(Exception e){
			throw new TwoException("Exception place in f()");
		}
	}
	
	public static Exception g() throws OneException{
		throw  new OneException("Exception place in g()");
	}
	
	

}

class OneException extends Exception{
	public OneException(String s){
		super(s);
	}
}

class TwoException extends Exception{
	public TwoException(String s){
		super(s);
	}
}
