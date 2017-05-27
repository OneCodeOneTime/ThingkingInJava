package btp.oneP;

public class SimpleFormat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 5;
		double y = 5.332542;
		System.out.println("["+x+","+y+"]");
		System.out.printf("[%d,%f]\n", x,y);
		System.out.format("[%d,%f]\n", x,y);
	}

}
