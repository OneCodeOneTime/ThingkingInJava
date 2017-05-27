package btp.oneP;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		Consumer<Command> c = new Consumer<Command>();
		c.pull(new Command("Jordan"));
		c.pull(new Command("Kobe"));
		c.pull(new Command("James"));
		c.pull(new Command("Durant"));
		c.pull(new Command("Kuru"));
		
		c.consume();c.consume();c.consume();c.consume();c.consume();c.consume();
	}

}

class Command{
	private String content;
	public void operation(){
		System.out.println(content);
	}
	public String toString(){
		return content;
	}
	public Command(String s){
		content=s;
	}
}

class fullQueue<E>{
	private Queue<E> queue;
	public fullQueue(){
		queue=new LinkedList<E>();
	}
	public E full(E e){
		if(queue.offer(e)){
			return e;
		}else{
			return null;
		}
	}
	public Queue<E> getQueue(){
		return queue;
	}
}


class Consumer<E>{
	private fullQueue<E> f = new fullQueue<E>();
	public  void consume(){
		E e=f.getQueue().poll();
		if(null!=e){
			System.out.println(e);
		}
		
	}
	public E pull(E e){
		return f.full(e);
	}
}