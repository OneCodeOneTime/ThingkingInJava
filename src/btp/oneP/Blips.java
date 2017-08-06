package btp.oneP;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class Blips {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Blip1 b1 = new Blip1();
		Blip2 b2 = new Blip2(9);
		ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("C:\\Users\\dell\\Desktop\\IO\\Blips.out"));
		o.writeObject(b1);
		o.writeObject(b2);
		o.close();
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\Users\\dell\\Desktop\\IO\\Blips.out"));
		b1 = (Blip1) in.readObject();
		b2 = (Blip2) in.readObject();
		
	}

}

class Blip1 implements Externalizable{
	public Blip1(){
		System.out.println("Blip1 Constructor");
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("Blip1.writeExternal");
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("Blip1.readExternal");
	}
	
}

//实现Externalizable接口的类必须要提供public的无参数的构造器，不然会报错。Serializable则不需要
class Blip2 implements Externalizable{
	public Blip2(int i){
		System.out.println("Blip2 Constructor");
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("Blip2.writeExternal");
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("Blip2.readExternal");
	}
	
}
