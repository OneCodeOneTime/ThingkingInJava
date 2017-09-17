package Chapter21.Concurrency;

public class ARunnable implements Runnable {
	public static int count = 0;
	final int id = count++;
	public ARunnable() {
		System.out.println(id+"Æô¶¯");
	}
	
	@Override
	public void run() {
		System.out.println(id+":run1...");
		Thread.yield();
		System.out.println(id+":run2...");
		Thread.yield();
		System.out.println(id+":run3...");
		Thread.yield();
	}

	public static void main(String[] args) {
		for(int i = 0;i<5;i++) {
			new Thread(new ARunnable()).start();
		}
	}

}
