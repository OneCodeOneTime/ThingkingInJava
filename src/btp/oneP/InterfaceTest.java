package btp.oneP;

public class InterfaceTest {

	public static void main(String[] args) {
		new InterfaceTest.Interface(){

			@Override
			public void get() {
				// TODO Auto-generated method stub
				
			}};
		new InterfaceTest().new Class();
	}

	public interface Interface{
		void get();
	}
	
	class Class{
		
	}
}
