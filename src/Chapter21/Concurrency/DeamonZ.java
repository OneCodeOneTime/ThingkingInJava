package Chapter21.Concurrency;

public class DeamonZ {

	public static void main(String[] args) {
		Thread thread = new Thread(new DeamonRunner(),"liershuang");System.out.println("----");
		thread.setDaemon(true);
		thread.start();
	}
	static class DeamonRunner implements Runnable{

		@Override
		public void run() {
			try {
				Thread.sleep(100000L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				System.out.println("DeamonThread finally run.");
			}
		}
		
	}
}
