package btp.oneP;

import java.io.PrintWriter;

public class ChangeSystemOut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//PrintWriter�н���OutputStream�Ĺ�������������OutputStreamWriterת��ΪWriter
		PrintWriter out = new PrintWriter(System.out,true);
		out.println("Hello,world");
	}

}
