package btp.oneP;

import java.util.LinkedList;

public class DequeTest {
	static void fillTest(Deque<Integer> deque){
		for(int i = 20;i < 27;i++){
			deque.addFirst(i);
		}
		for(int i = 50;i < 55;i++){
			deque.addLast(i);
		}
	}
	public static void main(String[] args) {
		Deque<Integer> di = new Deque<Integer>();
		fillTest(di);
		System.out.println(di);
		
		while(di.size() != 0){
			System.out.print(di.removeFirst()+" ");
		}
		System.out.println();
		
		fillTest(di);
		while(di.size() != 0){
			System.out.print(di.removeLast()+" ");
		}
		System.out.println();
	}

}


class Deque<T>{
	private LinkedList<T> deque = new LinkedList<T>();
	public void addFirst(T t){
		deque.add(t);
	}
	public void addLast(T t){
		deque.addLast(t);
	}
	public T getFirst(){
		return deque.getFirst();
	}
	public T getLast(){
		return deque.getLast();
	}
	public T removeFirst(){
		return deque.removeFirst();
	}
	public T removeLast(){
		return deque.removeLast();
	}
	public int size(){
		return deque.size();
	}
	public String toString(){
		return deque.toString();
	}
}