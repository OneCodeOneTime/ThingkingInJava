package btp.oneP;

import java.io.IOException;
import java.io.StringReader;

public class MemoryInput {

	public static void main(String[] args) throws IOException {
		StringReader im = new StringReader(BufferedInputFile.read("E:\\workspaces\\NewWork\\Study\\src\\btp\\oneP\\MemoryInput.java"));
		int c;
		while((c = im.read()) != -1){
			System.out.print((char)c);
		}
	}

}
