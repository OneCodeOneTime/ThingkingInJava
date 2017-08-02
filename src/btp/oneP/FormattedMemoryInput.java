package btp.oneP;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

public class FormattedMemoryInput {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try{
			DataInputStream in = new DataInputStream(new ByteArrayInputStream(BufferedInputFile.read("E:\\workspaces\\NewWork\\Study\\src\\btp\\oneP\\FormattedMemoryInput.java").getBytes()));
			while(true){
				System.out.print((char)in.readByte());
			}
		}catch(EOFException e){
			System.out.println("End of stream");
		}
	}

}
