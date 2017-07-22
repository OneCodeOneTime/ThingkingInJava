package btp.oneP;

public abstract class TestCollection<C> {
	String name;
	public TestCollection(String name){
		this.name = name;
	}
	abstract int test(C container,TestParam tp);
}
