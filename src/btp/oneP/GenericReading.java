package btp.oneP;

import java.util.Arrays;
import java.util.List;

public class GenericReading {
	static <T> T readExact(List<T> list){
		return list.get(0);
	}
	static List<Apple> apples = Arrays.asList(new Apple());
	static List<Fruit> fruit = Arrays.asList(new Fruit());
	
	static void f1(){
		Apple a = readExact(apples);
		Fruit f = readExact(fruit);
		f = readExact(apples);
	}
	
	static class Reader<T>{
		T readExact(List<T> list){
			return list.get(0);
		}
	}
	
	static void f2(){
		Reader<Fruit> fruitReader = new Reader<Fruit>();
		Fruit f = fruitReader.readExact(fruit);
		//Fruit a = fruitReader.readExact(apples);
	}
	
	static class CoveriantReader<T>{
		T readCovariantReader(List<? extends T> list){
			return list.get(0);
		}
	}
	
	static void f3(){
		CoveriantReader<Fruit> fruitReader = new CoveriantReader<Fruit>();
		Fruit f = fruitReader.readCovariantReader(fruit);
		Fruit a = fruitReader.readCovariantReader(apples);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			f1();f2();f3();
	}

}
