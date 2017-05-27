package btp.oneP;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class CharArrayClass {

	public static void main(String[] args) {
		
		try {
			//int a = TestFinal.a;
			//int b = TestFinal.b;
			//int c = TestFinal.c;
		
			//String s = TestFinal.s;
			//String ss = TestFinal.ss;
			//int ii = TestFinal.ii;
			//int sa = TestFinal.sa;
			Integer iii = TestFinal.iii;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class TestFinal{
	public static int sa = 100;
	public static final int  a = 5;
	public static final int  b = a+1;
	public static final int c = "length".length();
	public static final String s = "hello";
	public static final String ss = new String("world");
	public static final Integer ii = new Integer(2);
	public static final Integer iii = 2;
	static {
		System.out.println("class iniarzation...");
	}
	
}
