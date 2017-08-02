package btp.oneP;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class IntBufferDemo {
	private static final int SIZE = 1024;
	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.allocate(SIZE);
		IntBuffer ib = bb.asIntBuffer();
		ib.put(new int[]{11,24,54,23,123,6,8});
		System.out.println(ib.get(3));
		ib.put(3, 123);
		ib.flip();
		while(ib.hasRemaining()){
			int i = ib.get();
			System.out.print(i+" ");
		}
	}

}
