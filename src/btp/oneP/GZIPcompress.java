package btp.oneP;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZIPcompress {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(new File("C:\\Users\\dell\\Desktop\\IO\\test2.txt")));
		BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("C:\\Users\\dell\\Desktop\\IO\\test2.gz")));
		System.out.println("Writing file");
		int c;
		while((c = in.read()) != -1){
			out.write(c);
		}
		in.close();
		out.close();
		System.out.println("Reading file");
		BufferedReader in2 = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream("C:\\Users\\dell\\Desktop\\IO\\test2.gz"))));
		String s;
		while((s = in2.readLine()) != null){
			System.out.println(s);
		}
	}

}
