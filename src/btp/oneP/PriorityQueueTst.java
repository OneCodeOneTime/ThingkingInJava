package btp.oneP;

import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQueueTst {

	public static void main(String[] args) {
		PriorityQueue<IntegerPriority> pq = new PriorityQueue<IntegerPriority>();
		for(int i=0;i<10;i++){
			pq.add(new IntegerPriority());
		}
		System.out.println(pq);
		while(!pq.isEmpty()){
			System.out.println(pq.poll());
			System.out.println(pq);
		}
	}
	
	static class IntegerPriority implements Comparable<IntegerPriority>{
		Integer i;
		private Random rd = new Random();
		public IntegerPriority(){
			i = rd.nextInt(100);
		}
		@Override
		public int compareTo(IntegerPriority o) {
			if(this.i>o.i){
				return -1;
			}else if(this.i < o.i){
				return 1;
			}else return 0;
		}
		public String toString(){
			return Integer.toString(i);
		}
	}
}
