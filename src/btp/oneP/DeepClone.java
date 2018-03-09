package btp.oneP;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DeepClone implements Serializable,Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private DeepClone son;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public DeepClone getSon() {
		return son;
	}
	public void setSon(DeepClone son) {
		this.son = son;
	}

	public DeepClone(String name) {
		super();
		this.name = name;
	}
	public DeepClone deepClone() throws IOException, ClassNotFoundException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(this);
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		return (DeepClone)ois.readObject();
	}
	
	@Override
	public String toString() {
		return "DeepClone [name=" + name + ", son=" + son + "]";
	}
	public static void main(String[] args) throws ClassNotFoundException, IOException, CloneNotSupportedException {
		DeepClone f = new DeepClone("father");
		f.setSon(new DeepClone("son"));
		DeepClone clone = f.deepClone();
		System.out.println("Éî¿½±´£º"+clone);
		System.out.println(clone.getSon() == f.getSon());
		DeepClone ff = (DeepClone)f.clone();
		System.out.println("Ç³¿½±´£º"+ff);
		System.out.println(ff.getSon() == f.getSon());
	}

}
