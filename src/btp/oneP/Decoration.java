package btp.oneP;

import java.util.Date;

public class Decoration {

	public static void main(String[] args) {
		TimeStamped t = new TimeStamped(new Basic());
		TimeStamped t2 = new TimeStamped(new SerialNumbered(new Basic()));
		//t2.getSerialNumber();//Not available
		System.out.println(t2.getStamp());
		SerialNumbered s = new SerialNumbered(new Basic());
		SerialNumbered s2 = new SerialNumbered(new TimeStamped(new Basic()));
		SerialNumbered s3 = new SerialNumbered(new TimeStamped(new Basic()));
		System.out.println(s.getSerialNumber());
		System.out.println(s2.getSerialNumber());
		System.out.println(s3.getSerialNumber());
		//s2.getStamp();//Not available
	}

}


class Basic{
	private String value;
	public void set(String value){
		this.value = value;
	}
	public String get(){
		return value;
	}
}

class Decorator extends Basic{
	protected Basic basic;
	public Decorator(Basic basic){
		this.basic = basic;
	}
	public void set(String val){
		basic.set(val);
	}
	public String get(){
		return basic.get();
	}
}

class TimeStamped extends Decorator{
	private final long timeStamp;
	public TimeStamped(Basic basic) {
		super(basic);
		timeStamp = new Date().getTime();
	}
	public long getStamp(){
		return timeStamp;
	}
}

class SerialNumbered extends Decorator{
	private static long counter = 1;
	private final long serialNumber = counter++;
	public SerialNumbered(Basic basic) {
		super(basic);
	}
	public long getSerialNumber(){
		return serialNumber;
	}
}