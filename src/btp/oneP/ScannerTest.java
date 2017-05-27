package btp.oneP;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ScannerTest {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("C:/Users/dell/Desktop/黑名单说明.txt"));
		//sc.useDelimiter("\\d");
		while(sc.hasNext(Pattern.compile("\\d"))){
			System.out.println(sc.next("\\d"));
		}

	}

}
