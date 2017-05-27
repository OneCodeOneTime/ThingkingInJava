package btp.oneP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class New {
	public static <K,V> Map<K,V> map(){
		return new HashMap<K,V>();
	}
	public  <K,V> Map<K,V> maps(){
		return new HashMap<K,V>();
	}
	public static <T> List<T> list(){
		return new ArrayList<T>();
	}
	public static <T> Set<T> set(){
		return new HashSet<T>();
	}
	public static <T> Queue<T> queue(){
		return new LinkedList<T>();
	}
	static void f(Map<String,List<? extends Iterable>> p){
		p.put("test", new ArrayList<>());
		System.out.println(p.getClass().getName());
	}
	
	void fs(Map<String,List<? extends Iterable>> p){
		p.put("test", new ArrayList<>());
		System.out.println(p.getClass().getName());
	}
	void test(){
		this.fs(this.<String,List<? extends Iterable>>maps());
	}
	
	public static void main(String[] args) {
		System.out.println(New.map().getClass().getSimpleName());
		f(New.map());
	}
	

}
