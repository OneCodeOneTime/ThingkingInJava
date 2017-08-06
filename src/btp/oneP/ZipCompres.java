package btp.oneP;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipCompres {

	public static void main(String[] args) throws IOException {
		FileOutputStream f = new FileOutputStream("C:\\Users\\dell\\Desktop\\IO\\test.zip");
		CheckedOutputStream csum = new CheckedOutputStream(f,new Adler32());
		ZipOutputStream zos = new ZipOutputStream(csum);
		BufferedOutputStream out = new BufferedOutputStream(zos);
		zos.setComment("A test of Java Zipping");
		String[] adds = {"C:\\Users\\dell\\Desktop\\IO\\channelIn.txt","C:\\Users\\dell\\Desktop\\IO\\channelOut.txt","C:\\Users\\dell\\Desktop\\IO\\Data.txt","C:\\Users\\dell\\Desktop\\IO\\data2.txt"};
		for(String s:adds){
			System.out.println("Writing file");
			BufferedReader in = new BufferedReader(new FileReader(s));
			zos.putNextEntry(new ZipEntry(s));
			int c;
			while((c = in.read()) != -1){
				out.write(c);
			}
			in.close();
			out.flush();
		}
		
		out.close();
		System.out.println("Checksum: "+csum.getChecksum().getValue());
		
		System.out.println("Reading file");
		FileInputStream fi = new FileInputStream(new File("C:\\Users\\dell\\Desktop\\IO\\test.zip"));
		CheckedInputStream csumi = new CheckedInputStream(fi,new Adler32());
		ZipInputStream in2 = new ZipInputStream(csumi);
		BufferedInputStream bis = new BufferedInputStream(in2);
		ZipEntry ze;
		while((ze = in2.getNextEntry()) != null){
			System.out.println("Reading file "+ze);
			int x;
			while((x = bis.read()) != -1){
				System.out.print(x);
			}
		}
		bis.close();
		System.out.println("--------------------");
		ZipFile zf = new ZipFile("C:\\Users\\dell\\Desktop\\IO\\test.zip");
		Enumeration<? extends ZipEntry> e = zf.entries();
		while(e.hasMoreElements()){
			ZipEntry ze2 = e.nextElement();
			System.out.println(ze2);
		}
		
	}

}
