package btp.oneP;

import java.lang.reflect.Method;

public class LatentReflection {

	public static void main(String[] args) {
		CommunicateReflectively.perform(new SmartDog());
		CommunicateReflectively.perform(new Robott());
		CommunicateReflectively.perform(new Mime());
	}

}


class Mime{
	public void walkAgainstTheWind(){}
	public void sit(){
		System.out.println("Pretending to sit");
	}
	public void pushInvisibleWalls(){}
	public String toString(){
		return "Mime";
	}
}

class SmartDog{
	public void speak(){
		System.out.println("Wolf!");
	}
	public void sit(){
		System.out.println("Sitting!");
	}
	public void reproduce(){}
}

class CommunicateReflectively{
	public static void perform(Object speaker){
		Class<?> clazz = speaker.getClass();
		try{
			try{
				Method speak = clazz.getMethod("speak");
				speak.invoke(speaker);
			}catch(NoSuchMethodException e){
				System.out.println(speaker+" cannot speak");
			}
			
			try{
				Method sit = clazz.getMethod("sit");
				sit.invoke(speaker);
			}catch(NoSuchMethodException e){
				System.out.println(speaker+" cannot sit");
			}
		}catch(Exception e){
			throw new RuntimeException(speaker.toString(),e);
		}
	}
}