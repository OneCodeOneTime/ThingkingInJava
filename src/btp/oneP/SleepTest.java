package btp.oneP;

public class SleepTest {

	public static void main(String[] args) throws InterruptedException {
		Object o = new Object();
		Thread t1 = new Thread(new ST1(o));
		Thread t2 = new Thread(new ST2(o));
		t1.start();
		Thread.sleep(4000);
		t2.start();
		Thread.sleep(20000);
	}

}

class ST1 implements Runnable{
	private Object o;
	public ST1(Object o) {
		this.o = o;
	}
	@Override
	public void run() {
		System.out.println("ST1 get CPU...");
		synchronized(o) {
			System.out.println("ST1�����...");
			try {
				Thread.sleep(10000L);
				System.out.println("ST1 after sleep and get CPU");
			} catch (InterruptedException e) {
				System.out.println("ST1���ж�...");
			}
			System.out.println("ST1׼���ͷ���...");
		}
		System.out.println("ST1 realease CPU...");
	}
	
}

class ST2 implements Runnable{
	private Object o;
	public ST2(Object o) {
		this.o = o;
	}
	@Override
	public void run() {
		System.out.println("ST2 get CPU...");
		synchronized(o) {
			System.out.println("ST2�����...");
		}
		System.out.println("ST2 realease CPU...");
	}
	
}


/**
 * ʹ��ǰ���߳�ֹͣmillis�����ʱ�䡣
 * �̵߳���sleep(millis)������ʧȥ���ĳ���Ȩ��
 *
 * @param  millis
 *         �߳�ִֹͣ�еĺ�����
 *
 * @throws  IllegalArgumentException
 *          millisΪ����
 *
 * @throws  InterruptedException
 * 			����̱߳������߳��жϣ����̵߳��ж�״̬�ᱻ������׳����쳣��
 */
/*public static native void sleep(long millis) throws InterruptedException;*/
