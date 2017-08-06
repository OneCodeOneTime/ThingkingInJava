package btp.oneP;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerialCtl implements Serializable {
	private String a;
	private transient String b;
	{
		System.out.println("ÊµÀý³õÊ¼»¯");
	}
	public SerialCtl(){
		System.out.println("SerialCtl()");
	}
	public SerialCtl(String aa,String bb){
		System.out.println("SerialCtl(String,String)");
		a = "Not Transient:"+aa;
		b = "Transient:"+bb;
	}
	public String toString(){
		return a + "\n" + b;
	}
	private void writeObject(ObjectOutputStream stream) throws IOException{
		stream.defaultWriteObject();
		stream.writeObject(b);
	}
	private void readObject(ObjectInputStream stream) throws ClassNotFoundException, IOException{
		stream.defaultReadObject();
		b = (String) stream.readObject();
	}
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		SerialCtl sc = new SerialCtl("Test1","Test2");
		System.out.println("Before:\n"+sc);
		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		ObjectOutputStream o = new ObjectOutputStream(buf);
		o.writeObject(sc);
		ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buf.toByteArray()));
		SerialCtl sc2 = (SerialCtl) in.readObject();
		System.out.println("After:\n"+sc2);
	}

}
