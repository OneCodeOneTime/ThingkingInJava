package btp.oneP;

import java.util.Arrays;

public class ParameterizedArrayType {

	public static void main(String[] args) {
		Integer[] ints = {1,2,3,4,5};
		Double[] doubles = {1.1,2.2,3.3,4.4,5.5};
		Integer[] ints2 = new ClassParameter<Integer>().f(ints);
		System.out.println(Arrays.toString(ints2));
		System.out.println(ints == ints2);
		
		Double[] doubles2 = new ClassParameter<Double>().f(doubles);
		System.out.println(Arrays.toString(doubles2));
		
		ints = MethodParameter.f(ints);
		System.out.println(Arrays.toString(ints));
		doubles = MethodParameter.f(doubles);
	}

}

class ClassParameter<T>{
	public T[] f(T[] args){
		return args;
	}
}

class MethodParameter{
	public static <T> T[] f(T[] arg){
		return arg;
	}
}