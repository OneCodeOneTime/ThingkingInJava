package btp.oneP;

public class GenericFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericFunction gf = new GenericFunction();
		System.out.println(gf.genericMethod(String.class,2,"nihao"));
	}
	<T,V> T genericMethod(T t,V v,String s){
		return t;
	} 
}
