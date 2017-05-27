package btp.oneP;

public class TryCatchFinally {

	public static void main(String[] args) {
		System.out.println(getValue());
	}
	public static int getValue(){
		int i=1;
		try{
			return i;
		}finally{
			++i;
		}
	}

}
