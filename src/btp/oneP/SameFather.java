package btp.oneP;

public class SameFather {

	public static void main(String[] args) {
		Child1 c1 = new Child1();
		new Child2();
	}

}


class Father{
	{
		System.out.println("Father now!");
	}
	public Father(){
		System.out.println("Father");
	}
}

class Child1 extends Father{
	{
		System.out.println("Child1 now!");
	}
	public Child1(){
		System.out.println("Child1");
	}
}

class Child2 extends Father{
	{
		System.out.println("Child2 now!");
	}
	public Child2(){
		System.out.println("Child2");
	}
}
