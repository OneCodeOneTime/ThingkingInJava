package btp.oneP;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class GetData {
	private static final int BSIZE = 1024;
	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.allocate(BSIZE);
		int i = 0;
		System.out.println(bb.limit());
		while(i++ < bb.limit()){
			if(bb.get() != 0){
				System.out.print("nonzero");
			}
		}
		System.out.println("i = "+i);
		bb.rewind();
		bb.asCharBuffer().put("Howdy");
		char c;
		while((c = bb.getChar()) != 0){
			System.out.print(c+" ");
		}
		bb.rewind();
		bb.asShortBuffer().put((short)471142);
		System.out.println(bb.getShort());
		bb.rewind();
		bb.asIntBuffer().put(99471142);
		System.out.print(bb.getInt());
		
		System.out.println(Charset.forName(System.getProperty("file.encoding")).decode(bb));
		bb.rewind();
		bb.asLongBuffer().put(99471142);
		System.out.println(bb.getLong());
		bb.rewind();
		System.out.println(Charset.forName(System.getProperty("file.encoding")).decode(bb));
		bb.rewind();
		bb.asFloatBuffer().put(99471142);
		System.out.println(bb.getFloat());
		bb.rewind();
		bb.asDoubleBuffer().put(99471142);
		System.out.println(bb.getDouble());
		bb.rewind();
	}

}
