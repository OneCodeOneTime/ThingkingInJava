package btp.oneP;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

public class FileLocking {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileOutputStream fos = new FileOutputStream("C:\\Users\\dell\\Desktop\\IO\\file.txt");
		FileLock fl = fos.getChannel().tryLock();
		if(null != fl){
			System.out.println("Locked File");
			TimeUnit.MICROSECONDS.sleep(100);
			fl.release();
			System.out.println("Released Lock");
		}
		fos.close();
	}

}
