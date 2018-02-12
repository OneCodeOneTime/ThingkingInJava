package btp.oneP;

public class Thread4 extends Thread {
	protected volatile boolean stop;
	public static void main(String...args) throws InterruptedException {
		Thread4 t = new Thread4();
		t.start();
		Thread.sleep(20000);
		t.stop = true;
		
		
		t.interrupt();
		
		Thread.sleep(20000);
	}
	@Override
	public void run() {
		while(true) {
			System.out.println("stop="+stop);
			if(!stop) {
				System.out.println("working...");
				try {
					Thread.sleep(1000000);
				} catch (InterruptedException e) {
					System.out.println("interrupted...");
				}
			}else {
				System.out.println("break...");
				break;
			}
			
		}
	}
}
