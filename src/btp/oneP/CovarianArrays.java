package btp.oneP;

public class CovarianArrays {

	public static void main(String[] args) {
		Fruit[] fruit = new Apple[10];
		fruit[0] = new Apple();
		fruit[1] = new Jonathan();
		System.out.println(fruit[0]);
		System.out.println(fruit[1]);
		
		try{
			fruit[3] = new Fruit();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			fruit[4] = new Orange();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}


class Fruit{}
class Apple extends Fruit{}
class Jonathan extends Apple{}
class Orange extends Fruit{}