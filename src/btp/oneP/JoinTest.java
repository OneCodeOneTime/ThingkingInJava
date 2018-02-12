package btp.oneP;

public class JoinTest {

	public static void main(String[] args) throws InterruptedException {
		Thread jt2 = new Thread(new JT2());
		Thread jt1 = new Thread(new JT1(jt2));
		
		jt2.start();
		Thread.sleep(3000);
		jt1.start();
		//jt1.interrupt();��ʱjt1û��Ҫ��jt2����ټ���
		Thread.sleep(20000);
	}

}


class JT1 implements Runnable {
	private Thread t;
	public JT1(Thread t) {
		this.t= t;
	}
	
	@Override
	public void run() {
		System.out.println("JT1 executing...");
		try {
			//t.join();
			//t.join(1000L);
			t.join(0, 0);
			System.out.println("JT1 after JT2 join...");
		} catch (InterruptedException e) {
			//Thread.currentThread().interrupt();
			System.out.println("JT1 interrupted...");
		}
		
	}
	
}

class JT2 implements Runnable{

	@Override
	public void run() {
		/*while(true) {//�����Ļ�ST1����Զ�����������ִ����}*/
		System.out.println("JT2 executing...");
		try {
			Thread.sleep(10000);
			System.out.println("JT2 after sleep...");
		} catch (InterruptedException e) {
			System.out.println("JT2 interrupted...");
			//Thread.currentThread().interrupt();
		}
	}
	
}


/**
 * �ȴ�����join()�������߳���������ǰ�̲߳ż����������С�
 * �������߳�t1�����е�����t2.join()����t1Ҫ��t2����֮��ż���ִ�С�
 *
 * join()��join(0)Ч��һ����
 *
 * @throws  InterruptedException
 * 			����̴߳����е�����join���̱߳������߳��жϣ����׳����쳣�����ж�״̬�ᱻ�����
 * 			��ʵ�������t1�д�����t2.join()������˼����t1�ȴ�t2������ټ����������ж���
 * 			�������˼��t1�����t2�ˣ��Ͱ�t1�ж��ˣ�t1�Ͳ��ص�t2�������ɡ�
 */
/*public final void join() throws InterruptedException {
    join(0);
}*/


/**
 * �ȴ�����join(millis)�������߳�����millis���룬���millis����ʱ�������̻߳�δ��������
 * millis����ʱ���ڵ����߳̾������ˣ���ǰ�̼߳���ִ�С�
 * join(0)��join()Ч��һ������һֱ����ȥ��ֱ�������߳�������
 *
 *	join(millis)ʹ��ѭ�����this.isAlive()���жϵ����߳��Ƿ�����������join��ʹ��wait
 *	��ʵ�ֵģ����������̵߳��õ����̵߳�notifyAll()�����ͻ��ƻ�join�����������Ƽ�Ӧ�ó���
 *	�в�Ҫʹ���߳���Ϊ��������
 *
 * @param  millis
 *         �ȴ������ʱ��
 *
 * @throws  IllegalArgumentException
 *          millis�Ǹ���
 *
 * @throws  InterruptedException
 *          ͬjoin()
 */
/*public final synchronized void join(long millis)
throws InterruptedException {
    long base = System.currentTimeMillis();
    long now = 0;

    if (millis < 0) {
        throw new IllegalArgumentException("timeout value is negative");
    }

    if (millis == 0) {
        while (isAlive()) {
            wait(0);
        }
    } else {
        while (isAlive()) {
            long delay = millis - now;
            if (delay <= 0) {
                break;
            }
            wait(delay);
            now = System.currentTimeMillis() - base;
        }
    }
}*/