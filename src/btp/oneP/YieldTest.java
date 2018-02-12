package btp.oneP;

public class YieldTest {

	public static void main(String[] args) throws InterruptedException {
		Thread yt1 = new Thread(new YT1());
		Thread yt2 = new Thread(new YT2());
		yt1.start();
	
		yt2.start();
		Thread.sleep(20000);
	}

}

class YT1 implements Runnable{

	@Override
	public void run() {
		System.out.println("YT1 get CPU...");
		Thread.yield();
		System.out.println("YT1 after yield...");
	}
	
}

class YT2 implements Runnable{

	@Override
	public void run() {
		System.out.println("YT2 get CPU...");
		Thread.yield();
		System.out.println("YT2 after yield...");
	}
	
}
/**
 * ��ʾ���ȳ�����ô˷������߳�Ը���ó���ǰ�Ĵ�����ʹ��Ȩ�����������Ժ��Դ˰�ʾ������ᣩ��
 *
 * yield()��һ�ֽ����Եĳ��ԣ���Ϊ�˸����̼߳����תִ�У��������ʹ��CPU��ʹ�ô˷���
 * Ӧ�ý����ϸ�ķ����Ͳ����Ա�֤��������Ҫ��Ч����
 *
 * ���ٻ��õ��˷������������ڵ��ԺͲ��Է���Ƚ����ã�������ȥ����һЩ��̬���������bug��
 * ��Ҳ����� java.util.concurrent.locks֮��İ�ʱ���õ���
 */
/*public static native void yield();*/