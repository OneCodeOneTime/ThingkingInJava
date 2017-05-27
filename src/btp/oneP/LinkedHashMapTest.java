package btp.oneP;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class LinkedHashMapTest {
	 private static ScheduledExecutorService queueTimeOutCheckExecutorService = Executors.newScheduledThreadPool(2,
	            new ThreadFactory() {
	                private int threadIndex = 0;
	                
	                @Override
	                public Thread newThread(Runnable r) {
	                    Thread t = new Thread(r, "QueueTimeOutCheckThread-" + threadIndex++);
	                    t.setDaemon(true);
	                    return t;
	                }
	            });
	static{
		System.out.println(1);
		queueTimeOutCheckExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    
                    try {
                       System.out.println(1);
                    } finally {
                       
                    }
                    
                } catch (Exception e) {
                   
                }
            }
        }, 2000, 2000, TimeUnit.MILLISECONDS);
	}
	public static void main(String[] args) {
		
		System.out.println(11);
	}

}
