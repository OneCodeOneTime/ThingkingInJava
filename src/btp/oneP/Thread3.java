package btp.oneP;

public class Thread3 extends Thread {
	public void run() {
		while(true) {
			if(Thread.currentThread().isInterrupted()) {
				System.out.println("Someone interrupted me");
				break;
			}else {
				System.out.println("Thread is going...");
				
			}
		}
	}
	
	public static void main(String...args) throws InterruptedException {
		Thread3 t = new Thread3();
		t.start();
		Thread.currentThread().sleep(3000);
		t.interrupt();
	}
	
	/**
     * ���û�������̵߳��ö�������Object#notify()����Object#notifyAll()�������ǵ�����ͬһ��
     * ��������Object#wait()�������̻߳�һֱ�ȴ���
     * ����Object#wait()�͵���Object#wait(0)Ч����һ���ġ�
     * ����wait()���������Ȼ�ö�������wait()�������������ͷŵ�ǰӵ�еĶ�������һֱ�ȴ���
     * ֱ���������߳�ʹ��ͬһ������������notify()������notifyAll()�����ſ��ܼ���ִ��wait()
     * ֮��Ĵ��롣
     * ��һ��˵����Ϊ��ִ��wait()����֮�󣬿��ܻ����жϻ�����ٵĻ��ѣ�����wait()����һ
     * ��Ҫ����һ��ѭ���У�һ��wait()�����ĵ����ǰ���һ�������ģ���������ʱ�ŵ���wait()��
     * �жϻ�����ٻ��ѿ��ܷ���������������������£���������жϻ�����ٻ����ˣ�Ҫ��
     * �¼����������Ƿ����㣬����Ļ������µ���wait()����
     *     synchronized (obj) {
     *         while (&lt;condition does not hold&gt;)
     *             obj.wait();
     *         ... // Perform action appropriate to condition
     *     }
     * �мǣ�wait()�������뱻ӵ�ж��������̵߳��á����Բ鿴notify()�������˽��̻߳�ö���
     * ���Ķ��ַ�ʽ��
     *
     * @throws  IllegalMonitorStateException  ����wait()�������߳�û��ӵ��
     *               ��������
     * @throws  InterruptedException �߳��ڵ���wait()����֮ǰ��wait()�����ȴ���
     *             �������߳��ж��ˣ��ͻ��׳�����쳣�������ж�״̬λ��
     * @see        java.lang.Object#notify()
     * @see        java.lang.Object#notifyAll()
     */
   /* public final void wait() throws InterruptedException {
        wait(0);
    }*/
	
	/**
     * ���û�������̵߳��ö�������Object#notify()����Object#notifyAll()�������ǵ�����ͬһ��
     * ��������Object#wait(timeout)�������̻߳�һֱ�ȴ���timeout����ʱ�����ͬ����ֹͣ�ȴ���
     * ����wait(timeout)�������̱߳����ֻ�ö�������
     * ���������ѵ��������̷߳���������ĵȴ������У����һ���������������ϵȴ��Ķ����̻߳�ִֹͣ�����µ�
     * ���벢�������ߡ�ֱ�������ĸ�����������һ��
     * �����̵߳����������������notify()���������Ҹպ��������̱߳�ѡ�л��ѡ�
     * �����̵߳����������������notifyAll()������
     * �����̵߳����������̵߳�interrupt()������
     * �ܹ�ȥ�˲���timeout����ʱ�䡣���timeout��0�����̻߳�һֱ�ȴ���wait(0)��wait()Ч��һ����
     * �����ĸ�������һ�������ˣ��������߳̾ͻ�Ӷ������ĵȴ���������ȥ������������ȴ��������ϵ��߳�һ��
     * ���������������ʹ��Ȩ��һ����������������ͻᱻ�ָ�Ϊwait(timeout)ǰ��״̬������ȥtimeout����
     * ʱ��Ҳһ�����̻߳����ִ��wait(timeout)֮��Ĵ��롣
     * 
     * ���˱�notify()/notifyAll()�������жϺͳ�ʱ�������⣬�߳�Ҳ�ᱻ��ν����ٻ��ѡ���Ȼ�����������ʵ��
     * ���ٷ��������ǳ���������̱߳����ѵ������Ƿ����㣬����������Ӧ�ü����ó������ߡ�����wait(timeout)
     * ���������һ��ѭ���б����ã������Ļ����̱߳�����Ҳ���Լ�������Ƿ����㣺
     *     synchronized (obj) {
     *         while (&lt;condition does not hold&gt;)
     *             obj.wait(timeout);
     *         ... // Perform action appropriate to condition
     *     }
     *	����̱߳�java.lang.Thread#interrupt()�ж�֮�����wait(timeout)���ߵ���wait(timeout)�����б�
     *  java.lang.Thread#interrupt()�жϣ��ͻ��׳�InterruptedException������쳣�ڶ���
     *  �������õ�ʱ���׳���
     *
     * wait����ֻ�����ڽ����ǰ����������������ͬ����ǰ�̵߳Ķ������߳�����ʱ��Ȼ���Դ�������״̬��
     * �мǣ�wait(timeout)�������뱻ӵ�ж��������̵߳��á����Բ鿴notify()�������˽��̻߳�ö���
     * ���Ķ��ַ�ʽ��
     *
     * @param      timeout   �ȴ������ʱ������
     * @throws  IllegalArgumentException      ��timeoutΪ������
     * @throws  IllegalMonitorStateException  ������wait(timeout)�������߳�û�л�ö�������
     * @throws  InterruptedException ����̱߳�java.lang.Thread#interrupt()�ж�֮��
     * 									����wait(timeout)���ߵ���wait(timeout)�����б�
     *  								java.lang.Thread#interrupt()�ж��׳����쳣��
     *  								���������̵߳��ж�״̬��
     * @see        java.lang.Object#notify()
     * @see        java.lang.Object#notifyAll()
     */
   /* public final native void wait(long timeout) throws InterruptedException;*/
	
	
	/**
	 * ����һ���ڶ����������ߵ��̣߳�����ж�����ߵ��̣߳����⻽������һ�����ڶ����������ߵ��߳�ָ����
	 * �����˶�������wait����������wait�����е�����һ�������̡߳�
	 * �����ѵ��߳�ֻ���ڵ�ǰ�̷߳���������֮��ſ��ܼ���ִ�У������ѵ��̻߳�������ȴ������̣߳��ȴ�ִ��synchronized��
	 * һ������������ӵ��Ȩ�������ǹ�ƽ�ģ���������ȨҲ���������ơ�
	 * �˷���������ӵ�ж�������ǰ����ִ�У��̻߳�ö������ķ�ʽ�����֣�
     * ��ִ�ж�������ͬ������
     * ��ִ�ж�������ͬ������顣
     * �������������Class���ͣ�ִ�д���ľ�̬������
     * һ��������ĳһʱ��ֻ�ܱ�һ���̳߳��С�
     *
     * @throws  IllegalMonitorStateException  ������notify()�������̲߳��Ƕ�������ӵ���ߡ�
     * @see        java.lang.Object#notifyAll()
     * @see        java.lang.Object#wait()
     */
    /*public final native void notify();*/
	
	 /**
     * ���������ڶ����������ߵ��̡߳��ڶ����������ߵ��߳�ָ����
	 * �����˶�������wait����������wait�����е�����һ�������̡߳�
	 * �����ѵ��߳�ֻ���ڵ�ǰ�̷߳���������֮��ſ��ܼ���ִ�У������ѵ��̻߳�������ȴ������̣߳��ȴ�ִ��synchronized��
	 * һ������������ӵ��Ȩ�������ǹ�ƽ�ģ���������ȨҲ���������ơ�
     * �˷���������ӵ�ж�������ǰ����ִ�У��̻߳�ö������ķ�ʽ��Object#notify()������
     *
     * @throws  IllegalMonitorStateException  ������notify()�������̲߳��Ƕ�������ӵ���ߡ�
     * @see        java.lang.Object#notify()
     * @see        java.lang.Object#wait()
     */
    /*public final native void notifyAll();*/
}
