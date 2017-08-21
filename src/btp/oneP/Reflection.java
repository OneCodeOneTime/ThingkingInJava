package btp.oneP;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

public class Reflection {
	public static Set<String> analyze(Class<?> enumClass){
		System.out.println("----- Analyze " + enumClass + " -----");
		System.out.println("Interfaces:");
		for(Type t : enumClass.getGenericInterfaces()){
			System.out.print(t+" ");
		}
		System.out.println("Base: "+enumClass.getSuperclass());
		Set<String> methods = new TreeSet<String>();
		for(Method m : enumClass.getMethods()){
			methods.add(m.getName());
		}
		return methods;
	}
	
	public static void main(String[] args) {
		Set<String> exploreMethods = analyze(Explore.class);
		Set<String> enumMethods = analyze(Enum.class);
		System.out.println("Explore.containsAll(Enum)?"+exploreMethods.containsAll(enumMethods));
		System.out.println("Explore.removeAll(Enum):");
		exploreMethods.removeAll(enumMethods);
		System.out.println(enumMethods);
		System.out.println(exploreMethods);
	}

}

enum Explore{HERE,THERE}
