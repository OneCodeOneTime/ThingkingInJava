package btp.oneP;

public class ThrowTest {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		try {
			test1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try{
			test2();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("---------");
		
	}


	public static void test1() throws Exception{
		throw new Exception(){
			
		};
	}
	
	public static void test2(){
		throw new RuntimeException(){
			
		};
	}

}
