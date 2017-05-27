package btp.oneP;

import java.io.PrintStream;

public class RedixMain {

	public static void main(String[] args) {
		PrintStream p = System.out;
		//十进制转十六进制
		p.println(Integer.toHexString(112));
		//十进制转八进制
		p.println(Integer.toOctalString(112));
		//十进制转二进制
		p.println(Integer.toBinaryString(112));
		
		//二进制转十进制
		p.println(Integer.parseInt("01110000", 2));
		//八进制转十进制
		p.println(Integer.parseInt("160",8));
		//十六进制转十进制
		p.println(Integer.parseInt("70",16));
	}

}
