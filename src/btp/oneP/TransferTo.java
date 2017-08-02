package btp.oneP;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class TransferTo {

	public static void main(String[] args) throws IOException {
		FileChannel in = new FileInputStream("C:\\Users\\dell\\Desktop\\IO\\channelIn.txt").getChannel(),
				out = new FileOutputStream("C:\\Users\\dell\\Desktop\\IO\\channelOut.txt").getChannel();
		System.out.println(in.size());
		//out.position(in.size());
		out.transferFrom(in, 0, in.size());
		//in.transferTo(0, in.size(), out);
	}

}
