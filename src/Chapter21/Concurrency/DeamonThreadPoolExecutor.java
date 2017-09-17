package Chapter21.Concurrency;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DeamonThreadPoolExecutor extends ThreadPoolExecutor{
	public DeamonThreadPoolExecutor() {
		super(0,Integer.MAX_VALUE,60L,TimeUnit.SECONDS,new SynchronousQueue<Runnable>(),
				new DeamonThreadFactory());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
