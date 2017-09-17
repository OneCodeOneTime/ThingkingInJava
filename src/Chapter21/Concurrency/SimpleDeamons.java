package Chapter21.Concurrency;

import java.util.concurrent.TimeUnit;

public class SimpleDeamons implements Runnable{
	
	public static void main(String[] args) throws InterruptedException {
		for(int i=0;i<10;i++) {
			Thread deamon = new Thread(new SimpleDeamons());
			deamon.setDaemon(true);
			deamon.start();
		}
		System.out.println("All deamon start");
		//���ػ��߳�������ʱ�䣬��Ȼmain�߳�ִ�н�������ͽ����ˣ�ʱ��̵Ļ�������������10���ػ��̳߳���ͽ����� 
		TimeUnit.MICROSECONDS.sleep(15);
	}

	@Override
	public void run() {
		try {
			while(true) {
				TimeUnit.MICROSECONDS.sleep(100);
				System.out.println(Thread.currentThread()+" "+this);
			}
		}catch(InterruptedException e) {
			System.out.println("sleep() interrupted");
		}
	}

}
