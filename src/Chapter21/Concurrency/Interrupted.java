package Chapter21.Concurrency;

public class Interrupted {

	public static void main(String[] args) throws InterruptedException {
		Thread sleepT = new Thread(new SleepRunner(),"SleepThread");
		sleepT.setDaemon(true);
		Thread busyT = new Thread(new BusyRunner(),"BusyThread");
		busyT.setDaemon(true);
		sleepT.start();
		busyT.start();
		Thread.sleep(5000L);
		sleepT.interrupt();
		busyT.interrupt();
		busyT.interrupted();
		busyT.interrupted();
		Thread.sleep(5000L);
		System.out.println("sleepThread interrupted is "+sleepT.isInterrupted());
		System.out.println("busyThread interrupted is "+busyT.isInterrupted());
		Thread.sleep(10000L);
	}
	
	static class SleepRunner implements Runnable{

		@Override
		public void run() {
			while(true) {
				try {
					Thread.sleep(1000L);
				} catch (InterruptedException e) {
					System.out.println("÷–∂œ¡Àƒƒ");
				}
			}
		}
		
	}
	
	static class BusyRunner implements Runnable{

		@Override
		public void run() {
			while(true) {}
		}
		
	}
}
