package btp.oneP;

public class EraseBorder {
	
	public static <T extends i1> void f(T t){
		t.f1();
		t.f2();
		((c1) t).f3();
	}
	public static void main(String[] args) {
		f(new c1());
	}

}

interface i1{
	void f1();
	void f2();
}

class c1 implements i1{

	@Override
	public void f1() {
		System.out.println("c1.f1()");
	}

	@Override
	public void f2() {
		System.out.println("c1.f2()");
	}
	
	public void f3(){
		System.out.println("c1.f3()");
	}
}