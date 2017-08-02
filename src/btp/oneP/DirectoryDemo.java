package btp.oneP;

import java.io.File;
import java.io.IOException;

public class DirectoryDemo {

	public static void main(String[] args) throws IOException {
		PPrint.pprint(Directory.walk(".").dirs);
		for(File file : Directory.local(".", "T.*")){
			System.out.println(file);
		}
		System.out.println("---------------------");
		for(File file : Directory.local(".", "T.*\\.java")){
			System.out.println(file);
		}
		System.out.println("=====================");
		for(File file : Directory.local(".", ".*[Zz].*\\.class")){
			System.out.println(file);
		}
		
		File file = new File("C:\\Users\\dell\\Desktop\\pdf.js\\build.zip");
		file = new File("");
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getCanonicalPath());
		System.out.println(System.getProperty("user.dir"));
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("os.arch"));
		System.out.println(System.getenv());
	}

}
