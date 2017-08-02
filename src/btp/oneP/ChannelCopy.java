package btp.oneP;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelCopy {
	private static final int BSIZE = 1024;
	public static void main(String[] args) throws IOException {
		FileChannel in = new FileInputStream("C:\\Users\\dell\\Desktop\\IO\\channelIn.txt").getChannel(),
		out = new FileOutputStream("C:\\Users\\dell\\Desktop\\IO\\channelOut.txt").getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
		while(in.read(buffer) != -1){
			//д��֮��limit = capacity;position = ʵ�����ݴ�С
			buffer.flip();//limit->position;position->0
			out.write(buffer);
			buffer.clear();//limit->capacity;position->0;׼����һ·�Ķ�
		}
	}

}
