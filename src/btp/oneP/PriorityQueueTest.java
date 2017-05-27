package btp.oneP;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		PriorityQueue<Double> pq = new PriorityQueue<Double>(Collections.reverseOrder());
		pq.offer(5.67);
		pq.offer(66.6);
		pq.offer(789.0);
		pq.offer(222.2);
		pq.offer(0.00);
		System.out.println(pq.peek());
		
		PriorityQueue<Test> tq=new PriorityQueue<Test>();
		Map map=new HashMap();
		map.values();
	}
	
	class Test{}

}
