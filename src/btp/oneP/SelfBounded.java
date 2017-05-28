package btp.oneP;

//泛型归根到底就是一种限定
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
 * T为AS
 * AS继承自SelfBounded
 */
class AS extends SelfBounded<AS>{}

/*
 * T为BS
 * BS继承自SelfBounded
 */
class BS extends SelfBounded<AS>{}

class CS extends SelfBounded<CS>{}

class D{}
/*
 * D不是集成自SelfBounded，所以出错
 */
//class E extends SelfBounded<D>{}
/*
 * SelfBounded渴望一个类型参数，但是没有，所以会出警告
 */
class F extends SelfBounded{}

