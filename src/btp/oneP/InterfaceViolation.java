package btp.oneP;

import java.lang.reflect.Field;

public class InterfaceViolation {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Class clazz = FinalValueTest.class;
		FinalValueTest ob = new FinalValueTest();
		Field f1 = clazz.getDeclaredField("sss");
		f1.setAccessible(true);
		
		f1.set(ob, "sd");
		
		System.out.println(ob);
		f1.set(ob, "sddsf");
		System.out.println(ob);
	}

}

class FinalValueTest{
	int i = 1;
	private int j =2;
	private String s1 = new String("hehe");
	private String s2 = "22222";
	public final int k =3;
	private final int l = 4;
	public static int m = 5;
	static String s3 = "s3";
	public static final String CONSTANT = "faker";
	
	final String sss = null;
	@Override
	public String toString() {
		return "FinalValueTest [i=" + i + ", j=" + j + ", s1=" + s1 + ", s2=" + s2 + ", k=" + k + ", l=" + l + ",m="+m+",s3="+s3+",CONSTANT="+CONSTANT+",sss="+sss+"]";
	}
	
}