package btp.oneP;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.zip.DeflaterOutputStream;

public class ABtpTest {

	public static void main(String[] args) {
		PrintStream p = System.out;
		Scanner sc =new Scanner(System.in);
		try{
			/*ArrayList as = returnArray();
			ArrayList<String> ass = (ArrayList<String>)as;
			p.println(ass);
			as = returnArrayNew();
			p.println(as);
			ass = (ArrayList<String>)as;
			p.println(ass);*/
			
			List myIntList = new LinkedList();//1
			myIntList.add(new Integer(0));//2
			Integer x = (Integer) myIntList.iterator().next();//3
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			sc.close();
			p.close();
		}
	}
	
	public static ArrayList<String> returnArray(){
		return new ArrayList<String>(Arrays.asList(new String[]{"AA","BB","C"}));
	}
	
	public static ArrayList returnArrayNew(){
		return new ArrayList<String>(Arrays.asList(new String[]{"CC","DD","E"}));
	}
}