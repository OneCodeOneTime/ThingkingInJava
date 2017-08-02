package btp.oneP;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {
	private static final int BSIZE = 1024;
	@SuppressWarnings("resource")
	public static void main(String...args) throws IOException{
		FileChannel fc = new FileOutputStream("C:\\Users\\dell\\Desktop\\IO\\test.out").getChannel();
		fc.write(ByteBuffer.wrap("Some test".getBytes()));
		fc.close();
		fc = new RandomAccessFile("C:\\Users\\dell\\Desktop\\IO\\test.out","rw").getChannel();
		fc.position(fc.size());
		fc.write(ByteBuffer.wrap("Some more".getBytes()));
		fc.close();
		fc = new FileInputStream("C:\\Users\\dell\\Desktop\\IO\\test.out").getChannel();
		ByteBuffer buff = ByteBuffer.allocate(BSIZE);
		fc.read(buff);
		//把limit设置为position的值，position设置为0
		buff.flip();
		while(buff.hasRemaining()){
			System.out.print((char)buff.get());
		}
	}
}
