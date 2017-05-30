package btp.oneP;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FillTest {

	public static void main(String[] args) {
		List<Contract> contracts = new ArrayList<Contract>();
		Fill.fill(contracts, Contract.class, 3);
		System.out.println(contracts);
		
		Fill.fill(contracts, TitleTransfer.class, 2);
		System.out.println(contracts);
		
		SimpleQueue<Contract> cq = new SimpleQueue<Contract>();
		//Fill.fill(cq, Contract.class, 3);
	}

}

class Fill{
	public static <T> void fill(Collection<T> collection,Class<? extends T> classToken,int size){
		for(int i=0;i<size;i++){
			try{
				collection.add(classToken.newInstance());
			}catch(Exception e){
				throw new RuntimeException();
			}
		}
	}
}

class Contract{
	private static long counter;
	private final long id = counter++;
	public String getString(){
		return this.getClass().getName()+" "+id;
	}
}

class TitleTransfer extends Contract{
	
}
