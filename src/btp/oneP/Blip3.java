package btp.oneP;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class Blip3 implements Externalizable {
	private int i;
	private String s;
	public Blip3(){
		System.out.println("Blip3 Constructor");
	}
	public Blip3(String x,int a){
		System.out.println("Blip3(String x,int a)");
		s = x;
		i = a;
	}
	public String toString(){
		return s + i;
	}
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("Blip3.writeExternal");
		out.writeObject(s);
		out.writeInt(i);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Blip3.readExternal");
		s = (String)in.readObject();
		i = in.readInt();
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Blip3 b3 = new Blip3("A string",47);
		System.out.println(b3);
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		ObjectOutputStream o = new ObjectOutputStream(bout);
		o.writeObject(b3);
		o.close();
		ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
		b3 = (Blip3) in.readObject();
		System.out.println(b3);
	}

}
