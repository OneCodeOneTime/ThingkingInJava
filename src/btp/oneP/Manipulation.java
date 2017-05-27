package btp.oneP;

public class Manipulation {

	public static void main(String[] args) {
		HasF hf = new HasF();
		Manipulator<HasF> manipulator = new Manipulator<HasF>(hf);
		manipulator.manipulate();
	}

}

class HasF{
	public void f(){
		System.out.println("HasF.f()");
	}
}
class Manipulator<T extends HasF>{
	private T obj;
	public Manipulator(T x){this.obj = x;}
	public void manipulate(){obj.f();}
}

