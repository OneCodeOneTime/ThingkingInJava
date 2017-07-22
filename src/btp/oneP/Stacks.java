package btp.oneP;
import java.util.*;
public class Stacks {

	public static void main(String[] args) {
		java.util.Stack<String> stack = new java.util.Stack<String>();
		for(Month m:Month.values()){
			stack.push(m.toString());
		}
		stack.addElement("The last line");
		System.out.println("element 5 = "+stack.elementAt(5));
		System.out.println("popping elements:");
		while(!stack.empty()){
			System.out.println(stack.pop()+" ");
		}
		LinkedList<String> lstack = new LinkedList<String>();
		for(Month m : Month.values()){
			lstack.addFirst(m.toString());
		}
		System.out.println("lstack = "+lstack);
		while(!lstack.isEmpty()){
			System.out.println(lstack.removeFirst() + " ");
		}
	}

}

enum Month{
	JANUARY,FEBRUARY,MARCH,APRIL,MAY,JUNE,JULY,AUGUST,SEPTEMBER,OCTOBER,NOVEMBER
}
