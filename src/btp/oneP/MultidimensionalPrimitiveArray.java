package btp.oneP;

import java.util.Arrays;

public class MultidimensionalPrimitiveArray {

	public static void main(String[] args) {
		int[][] a = {{1,2,3},{4,5,6}};
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(a[1]));
		System.out.println(Arrays.deepToString(a));
	}

}
