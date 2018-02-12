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
 * 暗示调度程序调用此方法的线程愿意让出当前的处理器使用权，处理程序可以忽略此暗示（不理会）。
 *
 * yield()是一种建议性的尝试，是为了改善线程间的轮转执行，以免过度使用CPU。使用此方法
 * 应该结合详细的分析和测试以保证能有你想要的效果。
 *
 * 很少会用到此方法，它可能在调试和测试方面比较有用，它可以去重现一些竞态条件引起的bug，
 * 它也在设计 java.util.concurrent.locks之类的包时被用到。
 */
/*public static native void yield();*/