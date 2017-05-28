package btp.oneP;

//���͹�����׾���һ���޶�
public class SelfBounded<T extends SelfBounded<T>>{
	T element;
	SelfBounded<T> set(T t){
		this.element = t;
		return this;
	}
	T get(){
		return this.element;
	}
	
	public static void main(String[] args) {
		AS as = new AS();
		as.set(new AS());
		as=as.set(new AS()).get();
		as = as.get();
		CS cs = new CS();
		cs = cs.set(new CS()).get();
		
		BS bs = new BS();
		bs.set(new AS());
		as = bs.get();
		as = bs.set(new AS()).get();
	}

}
/*
 * TΪAS
 * AS�̳���SelfBounded
 */
class AS extends SelfBounded<AS>{}

/*
 * TΪBS
 * BS�̳���SelfBounded
 */
class BS extends SelfBounded<AS>{}

class CS extends SelfBounded<CS>{}

class D{}
/*
 * D���Ǽ�����SelfBounded�����Գ���
 */
//class E extends SelfBounded<D>{}
/*
 * SelfBounded����һ�����Ͳ���������û�У����Ի������
 */
class F extends SelfBounded{}

