package btp.oneP;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

@SuppressWarnings("serial")
public class TextFile extends ArrayList<String> {
	
	public static String read(String fileName){
		StringBuilder sb = new StringBuilder();
		try{
			BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
			try{
				String s;
				while((s = in.readLine()) != null){
					sb.append(s);
					sb.append("\n");
				}
			}finally{
				in.close();
			}
		}catch(IOException e){
			throw new RuntimeException();
		}
		return sb.toString();
	}
	
	public static void write(String fileName,String text){
		try{
			PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
			try{
				out.print(text);
			}finally{
				out.close();
			}
		}catch(IOException e){
			throw new RuntimeException();
		}
	}
	
	public TextFile(String fileName,String splitter){
		super(Arrays.asList(read(fileName).split(splitter)));
		if("".equals(get(0))){
			remove(0);
		}
	}
	
	public TextFile(String fileName){
		this(fileName,"\n");
	}
	
	public void write(String fileName){
		try{
			PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
			try{
				for(String item : this){
					out.println(item);
				}
			}finally{
				out.close();
			}
		}catch(IOException e){
			throw new RuntimeException();
		}
	}
	
	public static void main(String[] args) {
		String file = read("E:\\workspaces\\NewWork\\Study\\src\\btp\\oneP\\TextFile.java");
		System.out.println(file);
		write("C:\\Users\\dell\\Desktop\\IO\\test.txt",file);
		TextFile text = new TextFile("C:\\Users\\dell\\Desktop\\IO\\test.txt");
		text.write("C:\\Users\\dell\\Desktop\\IO\\test2.txt");
		TreeSet<String> words = new TreeSet<String>(new TextFile("E:\\workspaces\\NewWork\\Study\\src\\btp\\oneP\\TextFile.java","\\W+"));
		System.out.println(words.headSet("a"));
	}

}
