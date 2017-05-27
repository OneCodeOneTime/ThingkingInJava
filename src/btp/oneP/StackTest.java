package btp.oneP;

import java.util.LinkedList;

public class StackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Character> stack=new Stack<Character>();
		String s="+U+n+c---+e+r+t---+a-+i-+n+t+y---+-+r+u--+l+e+s---";
		boolean add=false;
		for(char c:s.toCharArray()){
			if(c=='+'){
				add=true;
				continue;
			}
			if(add){
				stack.push(c);
				add=false;
				continue;
			}
			if(c=='-'){
				System.out.print(stack.pop());
				add=false;
			}
		}
	}

}

class Stack<T>{
	private LinkedList<T> ll=null;
	public Stack(){
		ll=new LinkedList<T>();
	}
	public void push(T t){
		ll.addFirst(t);
	}
	public T peek(){
		return ll.peek();
	}
	public T pop(){
		return ll.poll();
	}
	public boolean isEmpty(){
		return ll.isEmpty();
	}
	public String toString(){
		return ll.toString();
	}
}
