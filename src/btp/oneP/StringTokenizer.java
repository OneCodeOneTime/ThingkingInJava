package btp.oneP;

public class StringTokenizer {

	public static void main(String[] args) {
		java.util.StringTokenizer sk = 
				new java.util.StringTokenizer("nihao\'khds\tjhjskd\tdf","\'",true);
		while(sk.hasMoreTokens()){
			System.out.println(sk.nextToken());
		}
	}

}
