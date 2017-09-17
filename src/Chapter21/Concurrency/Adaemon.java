package Chapter21.Concurrency;

import java.util.concurrent.TimeUnit;

public class Adaemon implements Runnable {

	@Override
	public void run() {
		try {
			System.out.println("Starting Adeamon");
			TimeUnit.SECONDS.sleep(1);
		}catch(InterruptedException e) {
			System.out.println("Exiting via InterruptedException");
		}finally {
			System.out.println("This should always run?");
		}
	}

	public static void main(String[] args) {
		Thread t = new Thread(new Adaemon());
		t.setDaemon(true);
		t.start();
	}

}
