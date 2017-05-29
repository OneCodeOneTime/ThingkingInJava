package btp.oneP;

public class CRGWithBasicHolder {

	public static void main(String[] args) {
		Subtype st1 = new Subtype(),st2 = new Subtype();
		st1.set(st2);
		Subtype st3 = st1.get();
		st1.f();
	}

}

class BasicHolder<T>{
	T element;
	void set(T t){
		element = t;
	}
	T get(){
		return this.element;
	}
	void f(){
		System.out.println(this.element.getClass().getName());
	}
}

class Subtype extends BasicHolder<Subtype>{}