package btp.oneP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckedList {
	
	@SuppressWarnings("unchecked")
	static void oldStyleMethod(List probablyDogs){
		probablyDogs.add(new Cat());
	}
	
	public static void main(String[] args) {
		List<Dog> dogs1 = new ArrayList<Dog>();
		oldStyleMethod(dogs1);
		System.out.println(dogs1);
		List<Dog>s2 = Collections.checkedList(new ArrayList<Dog>(), Dog.class);
		try{
			oldStyleMethod(s2);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//work fine 
		List<Pet> pets = Collections.checkedList(new ArrayList<Pet>(), Pet.class);
		pets.add(new Dog());
		pets.add(new Cat());
		pets.add(new Pet());
		oldStyleMethod(pets);
		System.out.println(pets);
	}

}

class Pet{}
class Dog extends Pet{}
class Cat extends Pet{}

