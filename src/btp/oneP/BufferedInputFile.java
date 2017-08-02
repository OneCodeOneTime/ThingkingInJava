package btp.oneP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedInputFile {
	
	public static String read(String filename) throws IOException{
		BufferedReader im = new BufferedReader(new FileReader(filename));
		String s;
		StringBuilder sb = new StringBuilder();
		while((s = im.readLine()) != null){
			sb.append(s+"\n");
		}
		im.close();
		return sb.toString();
	}
	public static void main(String[] args) throws IOException {
		System.out.println(read("E:\\workspaces\\NewWork\\Study\\src\\btp\\oneP\\BufferedInputFile.java"));
	}

}
