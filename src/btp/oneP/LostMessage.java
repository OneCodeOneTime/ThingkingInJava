package btp.oneP;

public class LostMessage {

	@SuppressWarnings("finally")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			LostMessage lm = new LostMessage();
			try {
				lm.f();
			} catch(VeryImportantException e){
				throw e;
			}finally{
				lm.dispose();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
//		try{
//			throw new RuntimeException();
//		}finally{
//			return;
//		}
	}
	
	void f() throws VeryImportantException{
		throw new VeryImportantException();
	}
	void dispose() throws HoHumException{
		throw new HoHumException();
	}

}

class VeryImportantException extends Exception{
	public String toString(){
		return "A very important exception";
	}
}

class HoHumException extends Exception{
	public String toString(){
		return "A trivial exception";
	}
}
