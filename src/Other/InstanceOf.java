package Other;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;

public class InstanceOf implements Cloneable{
	private int num = 0;
	public boolean isTrue(){
		return this.clone().equals(this);
	}
	public static void main(String[] args) throws CloneNotSupportedException {
		InstanceOf io = new InstanceOf();
		System.out.println(io.isTrue());
		
	}
	@Override
	public InstanceOf clone() {
		return new InstanceOf();
	}
	@Override
	public boolean equals(Object o) {
		return this.getNum() == ((InstanceOf)o).getNum();
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}

class Foo{
	public Foo create() {
		return new Foo();
	}
}
class Bar extends Foo{
	@Override
	public Bar create() {
		return new Bar();
	}
}
class Baz extends Bar{
	@Override
	public Bar create() {
		return new Baz();
	}
}





