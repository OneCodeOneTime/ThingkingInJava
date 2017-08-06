package btp.oneP;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class Logon implements Serializable {
	private Date date = new Date();
	private String username;
	private transient String password;
	public Logon(String name,String pwd){
		this.username = name;
		this.password = pwd;
	}
	public String toString(){
		return "logon info:\n username: "+username+"\n date:"+date+"\n password:"+password;
	}
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Logon a = new Logon("btp","god");
		System.out.println(a);
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		ObjectOutputStream o = new ObjectOutputStream(bout);
		o.writeObject(a);
		ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
		a = (Logon) in.readObject();
		System.out.println(a);
		
		
	}

}
