package btp.oneP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessTest {

	public static void main(String[] args) {
		try{
			//Process proc = Runtime.getRuntime().exec("ipconfig");
			Process proc = new ProcessBuilder("winver").start();
			BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String s;
			while((s = br.readLine()) != null){
				System.out.println(s);
			}
			System.out.println(System.getProperty("java.io.tmpdirs"));
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
