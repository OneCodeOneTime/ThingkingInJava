package btp.oneP;

public class DogsAndRobots {

	public static void main(String[] args) {
		PerformingDog d = new PerformingDog();
		Robott r = new Robott();
		Communicate.perform(d);
		Communicate.perform(r);
	}

}

interface Performs{
	void speak();
	void sit();
}

class PerformingDog extends Dog implements Performs{

	@Override
	public void speak() {
		System.out.println("Woof!");
	}

	@Override
	public void sit() {
		System.out.println("Sitting!");
	}
	
	public void reproduce(){}
}

class Robott implements Performs{

	@Override
	public void speak() {
		System.out.println("Click!");
	}

	@Override
	public void sit() {
		System.out.println("Clank!");
	}
	
	public void oilChange(){}
	
}

class Communicate{
	public static <T extends Performs> void perform(T performs){
		performs.speak();
		performs.sit();
	}
	
	//下面和上面的一样，不构成重载
	/*public static void perform(Performs p){
		p.speak();
		p.sit();
	}*/
}