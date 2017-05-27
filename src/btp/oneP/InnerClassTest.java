package btp.oneP;

public class InnerClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a=new A();
		A.AA aa=a.new AA();
		A.AA.AAA aaa=aa.new AAA();
		System.out.println(aaa.getI3());
		System.out.println(aaa.getI2());
		System.out.println(aaa.getI1());
	}

}


class A{
	private int i=12;
	class AA{
		private int i=13;
		class AAA{
			private int i=14;
			public int getI3(){
				return i;
			}
			public int getI2(){
				return AA.this.i;
			} 
			public int getI1(){
				return A.this.i;
			}
		}
	}
}
