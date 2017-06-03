package btp.oneP;

import java.util.Arrays;

public class ThreeWithNew {

	public static void main(String[] args) {
		int[][][] a = new int[2][2][4];
		System.out.println(a);
		System.out.println(Arrays.toString(a));
		System.out.println("a.length:"+a.length);
		System.out.println(Arrays.toString(a[0]));
		System.out.println("a[0].length:"+a[0].length);
		System.out.println(Arrays.toString(a[1]));
		System.out.println("a[1].length:"+a[1].length);
		System.out.println(Arrays.toString(a[0][1]));
	}

}
