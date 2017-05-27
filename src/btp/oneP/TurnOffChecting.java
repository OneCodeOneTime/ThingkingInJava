package btp.oneP;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TurnOffChecting {

	public static void main(String[] args) {
		WrapCheckedException wce = new WrapCheckedException();
		wce.throwRuntimeException(3);
			for(int i=0;i<4;i++){
				try{
					if(i<3){
						wce.throwRuntimeException(i);
					}else{
						throw new SomeOtherException();
					}
				}catch(SomeOtherException e){
					System.out.println("SomeOtherException");
				}catch(RuntimeException e){
					try {
						throw e.getCause();
					} catch (FileNotFoundException e1) {
						System.out.println("FileNotFoundException");
					}catch(IOException e2){
						System.out.println("IOException");
					}catch(Throwable e3){
						System.out.println("Throwable");
					}
				}
			}
		

	}

}
class SomeOtherException extends Exception{}

class WrapCheckedException{
	void throwRuntimeException(int type){
		try{
			switch(type){
			case 0:throw new FileNotFoundException();
			case 1:throw new IOException();
			case 2:throw new RuntimeException("where am I?");
			default:return;
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}
