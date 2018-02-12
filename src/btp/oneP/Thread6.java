package btp.oneP;

public class Thread6 {
	public static void main(String...args) throws InterruptedException {
		Object o = new Object();
		/*����6���̣߳�1��ET1��5��ET2*/
		ET1 et1 = new ET1(o);
		Thread t1 = new Thread(et1);
		Thread t2_1 = new Thread(new ET2(o,et1));
		Thread t2_2 = new Thread(new ET2(o,et1));
		Thread t2_3 = new Thread(new ET2(o,et1));
		Thread t2_4 = new Thread(new ET2(o,et1));
		Thread t2_5 = new Thread(new ET2(o,et1));
		//����t1ִ��
		t1.start();
		Thread.sleep(5000);
		t2_1.start();t2_2.start();t2_3.start();t2_4.start();t2_5.start();
		t1.interrupt();
		//����߳��л���һ���̻߳��Ȼ����������߳�ִ����ỽ��wait��t1���ҽ�������������Ϊtrue����t1��ʣ�µ��ĸ��߳�һ��������
		Thread.sleep(20000);
	}
}

class ET1 implements Runnable{
	//�̵߳�����������ֻҪconditionΪfalse���߳̾�Ҫ����
	private boolean condition;
	
	/**
	 * ������
	 */
	Object o;
	public ET1(Object o) {
		this.o = o;
	}
	@Override
	public void run() {
		synchronized(o) {
			System.out.println("ET1�����...");
			try {
				//��ֹ��ٻ��ѣ���ٻ��ѵ�ʱ��condition��һ�����㣩�������ظ��������
				while(!condition) {
					o.wait();	
				}
				
				System.out.println("ET1 after wait...");
			} catch (InterruptedException e) {
				System.out.println("ET1���ж�...");
				//���ж�ҲҪ���������������ҲҪ��������
				while(!condition) {
					try {
						System.out.println("ET1���жϵ������������㣬��������...");
						o.wait();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				}
			}
		}
		System.out.println("ET1ִ������ͷ���...");
	}
	public boolean isCondition() {
		return condition;
	}
	public void setCondition(boolean condition) {
		this.condition = condition;
	}
	
}

class ET2 implements Runnable{
	public static int count = 0;
	private int no;
	private ET1 et1;
	
	/**
	 * ������
	 */
	Object o;
	public ET2(Object o,ET1 et1) {
		this.o = o;
		this.et1 = et1;
		this.no = count++;
	}
	@Override
	public void run() {
		System.out.println(this+"�ȴ���ö�����...");
		synchronized(o) {
			System.out.println(this+"��ö�����...");
			o.notify();
			//����et1������Ϊtrue������et1�Ͳ����������
			et1.setCondition(true);
			System.out.println(this+"�ͷ���");
		}
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	@Override
	public String toString() {
		return "ET2 [no=" + no + "]";
	}
}