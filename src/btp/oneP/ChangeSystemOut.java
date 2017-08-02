package btp.oneP;

import java.io.PrintWriter;

public class ChangeSystemOut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//PrintWriter有接受OutputStream的构造器，将其用OutputStreamWriter转换为Writer
		PrintWriter out = new PrintWriter(System.out,true);
		out.println("Hello,world");
	}

}
