package btp.oneP;

public class ToyTest {
	static void printInfo(Class c){
		System.out.println("Class name: "+c.getName()+" is interface?["+c.isInterface()+"]");
		System.out.println("simple name:"+c.getSimpleName());
		System.out.println("canonical name:"+c.getCanonicalName());
	}
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		Class c = null;
		try {
			c=Class.forName("btp.oneP.FancyToy");
			System.out.println(c.getSuperclass());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printInfo(c);
		System.out.println("---------------");
		Class[] classes = c.getInterfaces();
		for(Class cc:classes){
			printInfo(cc);
			System.out.println("----------------");
		}
		System.out.println(c.newInstance().getClass());
	}

}

interface HasBatteries{}
interface Waterproof{}
interface Shoots{}

class Toy{
	//Toy(){}
	//Toy(int i){}
}
class FancyToy extends Toy implements HasBatteries,Waterproof,Shoots{

//	FancyToy(int i) {
//		super(i);
//		// TODO Auto-generated constructor stub
//	}
	FancyToy(){}
} 

