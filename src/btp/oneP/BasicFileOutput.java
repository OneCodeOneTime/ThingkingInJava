package btp.oneP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class BasicFileOutput {
	static String file = "C:\\Users\\dell\\Desktop\\IO\\io.txt";
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read("E:\\workspaces\\NewWork\\Study\\src\\btp\\oneP\\BasicFileOutput.java")));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
		int lineCount = 1;
		String s;
		while((s = in.readLine()) != null){
			out.println(lineCount++ + " : " + s);
		}
		out.close();
		System.out.println(BufferedInputFile.read(file));
	}

}
