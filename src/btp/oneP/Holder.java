package btp.oneP;

public class Holder<T> {
	
	private T value;
	public Holder(){}
	public Holder(T val){
		value = val;
	}
	public void set(T val){
		value = val;
	}
	public T get(){
		return value;
	}
	public boolean equals(Object obj){
		return this.value.equals(obj);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Holder<Integer> apple = new Holder<Integer>(new Integer(1));
		Integer i =apple.get();
		apple.set(i);
		//Holder<Number> holderNumber = apple;
		Holder<? extends Number> number = apple;
		number.set(null);
		Number n = number.get();
		i = (Integer)number.get();
		System.out.println(i);
		
		try{
			Float f = (Float)number.get();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
