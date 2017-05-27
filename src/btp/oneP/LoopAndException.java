package btp.oneP;

public class LoopAndException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		f();
		System.out.println("-----------------");
		m();
	}
	
	static void f(){
		try{
			for(int i=0;i<10;i++){
				if(i==2){
					throw new RuntimeException();
				}
				System.out.println(i);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
	}
	
	static void m(){
		for(int i=0;i<10;i++){
			try{
				if(i==2){
					throw new RuntimeException();
				}
				System.out.println(i);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}


