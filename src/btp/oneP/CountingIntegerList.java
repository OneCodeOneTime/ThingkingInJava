package btp.oneP;

import java.util.AbstractList;

public class CountingIntegerList extends AbstractList<Integer>{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//构造函数构造对象时里面还没有值，都是null，在调用toString函数的时候，
		//toString函数内使用Iterator遍历集合，next()时调用了get(index)
		//所以是边赋值边打印
		System.out.println(new CountingIntegerList(30));
	}

	
	private int size;
	public CountingIntegerList(int size){
		this.size = size<0?0:size;
	}
	
	@Override
	public Integer get(int index) {
		// TODO Auto-generated method stub
		return Integer.valueOf(index);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

}
