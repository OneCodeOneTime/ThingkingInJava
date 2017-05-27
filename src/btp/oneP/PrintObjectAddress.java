package btp.oneP;

import java.util.Arrays;

public class PrintObjectAddress {

	public static void main(String[] args) {
		String s1 = new String("s1");
		String s2 = new String(new StringBuilder("S2"));
		String s3 = new String(new StringBuffer("s3"));
		String s4 = new String(new char[]{'s','4'});
		String s5 = new String(new byte[]{65,97});
		
		char[] cs = new char[5];
		s1.getChars(0, 2, cs, 3);
		cs = s1.toCharArray();
		System.out.println(Arrays.toString(cs));
		
		System.out.println(s1.contentEquals(new StringBuffer("s1")));
		
		System.out.println(s1.regionMatches(true,0, s2, 0, 1));
		
//		System.out.println(s1);
//		System.out.println(s2);
//		System.out.println(s3);
//		System.out.println(s4);
//		System.out.println(s5);
	}

}

class PrintObject  extends Object{
	public String toString(){
		return "ÄãºÃ";
	}
}
