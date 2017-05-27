package btp.oneP;

public class LinkedStack<T>{
	class Node<U>{
		T t;
		U item;
		Node<U> next;
		Node(){
			this.item = null;
			this.next = null;
		}
		Node(U item,Node<U> next){
			this.item = item;
			this.next = next;
		}
		boolean end(){
			return item==null&&next==null;
		}
	}
	private Node<T> top = new Node<T>();
	public void push(T item){
		//top = new Node<T>(item,top);
		Node<T> node = new Node<T>();
		node.item = item;
		node.next = top;
		top = node;
	}
	public T pop(){
		T result = top.item;
		if(!top.end()){
			top=top.next;
		}
		return result;
	}
	
	public static void main(String[] args) {
		LinkedStack<String> lss = new LinkedStack<>();
		for(String s:"i love eating meat".split(" ")){
			lss.push(s);
		}
		String s;
		while((s = lss.pop())!= null){
			System.out.println(s);
		}
		
	}

}
