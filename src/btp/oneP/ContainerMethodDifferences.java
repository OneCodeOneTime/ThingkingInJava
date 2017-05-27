package btp.oneP;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class ContainerMethodDifferences {
	static Set<String> methodSet(Class<?> type){
		Set<String> result = new TreeSet<String>();
		for(Method m : type.getMethods()){
			result.add(m.getName());
		}
		return result;
	}
	static void interfaces(Class<?> type){
		System.out.println("Interfaces in"+type.getSimpleName()+": ");
		List<String> result = new ArrayList<String>();
		for(Class<?> c:type.getInterfaces()){
			result.add(c.getSimpleName());
		}
		System.out.println(result);
	}
	static Set<String> object = methodSet(Object.class);
	static{
		object.add("clone");
	}
	static void difference(Class<?> superset,Class<?> subset){
		System.out.println(superset.getSimpleName()+" extends "+subset.getSimpleName()+",adds: ");
		Set<String> comp = Sets.difference(methodSet(superset),methodSet(subset));
		comp.removeAll(object);
		System.out.println(comp);
		interfaces(superset);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Collection: "+methodSet(Collection.class));
		interfaces(Collection.class);
		difference(Set.class,Collection.class);
		difference(HashSet.class,Set.class);
		difference(LinkedHashSet.class,HashSet.class);
		difference(TreeSet.class,Set.class);
		difference(List.class,Collection.class);
		difference(ArrayList.class,List.class);
		difference(LinkedList.class,List.class);
		difference(Queue.class,Collection.class);
		difference(PriorityQueue.class,Queue.class);
		System.out.println("Map:"+methodSet(Map.class));
		difference(HashMap.class,Map.class);
		difference(LinkedHashMap.class,HashMap.class);
		difference(SortedMap.class,Map.class);
		difference(TreeMap.class,Map.class);
	}

}

class Sets{
	public static <T> Set<T> union(Set<T> set1,Set<T> set2){
		Set<T> result = new HashSet<T>(set1);
		result.addAll(set2);
		return result;
	}
	
	public static <T> Set<T> intersection(Set<T> set1,Set<T> set2){
		Set<T> result = new HashSet<T>(set1);
		result.retainAll(set2);
		return result;
	}
	public static <T> Set<T> difference(Set<T> set1,Set<T> set2){
		Set<T> result = new HashSet<T>(set1);
		result.removeAll(set2);
		return result;
	}
	public static <T> Set<T> complement(Set<T> set1,Set<T> set2){
		return difference(union(set1,set2),intersection(set1,set2));
	}
}
