package btp.oneP;

public class ArrayTest {

	public static void main(String[] args) {
		//f({1,2,3});
		f(new int[]{1,2,3});
	}
	
	static void f(int[] a){
		for(int i:a){
			System.out.println(i);
		}
	}

}
