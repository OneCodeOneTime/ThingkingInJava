package btp.oneP;

@ExtractInterface("IMultiplier")
public class Multiolier {
	public int Multiply(int x,int y){
		int total = 0;
		for(int i = 0;i<x;i++){
			total = add(total,y);
		}
		return total;
	}
	
	private int add(int x,int y){
		return x+y;
	}
	
	public static void main(String[] args) {
		Multiolier m = new Multiolier();
		System.out.println("11*16="+m.Multiply(11, 16));
	}

}
