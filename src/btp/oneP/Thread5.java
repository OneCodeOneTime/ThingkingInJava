package btp.oneP;

public class Thread5 extends Thread {

	public static void main(String[] args) throws InterruptedException {
		Thread5 t5 = new Thread5();
		t5.start();
		Thread.sleep(10000);
		t5.interrupt();
		Thread.sleep(10000);
	}

	@Override
	public void run() {
		while(true)
		System.out.println("run...");
	}
}
