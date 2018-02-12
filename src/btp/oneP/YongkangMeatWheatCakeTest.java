package btp.oneP;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 现在有很多卖永康肉麦饼的店子，一个做饼的师傅，台子上有盘子，假定盘子只能放一定数量的
 * 饼，还有很多客户来买。
 * @author baitp
 *
 */
public class YongkangMeatWheatCakeTest {

	public static void main(String[] args) throws InterruptedException {
		//饼盘子
		BlockingQueue<YongkangMeatWheatCake> bq = new ArrayBlockingQueue<YongkangMeatWheatCake>(10);
		//一个师傅
		Thread saysay = new Thread(new Craftsman(bq));
		//多个客户
		Thread c1 = new Thread(new Customer(bq));
		Thread c2 = new Thread(new Customer(bq));
		Thread c3 = new Thread(new Customer(bq));
		Thread c4 = new Thread(new Customer(bq));
		Thread c5 = new Thread(new Customer(bq));
		//启动
		saysay.start();
		c1.start();c2.start();c3.start();c4.start();c5.start();
		Thread.sleep(20000);
	}
}

/**
 * 做饼师傅
 *
 */
class Craftsman implements Runnable{
	/**
	 * 放饼的盘子，师傅往里面放饼
	 */
	private BlockingQueue<YongkangMeatWheatCake> bq;
	
	public Craftsman(BlockingQueue<YongkangMeatWheatCake> bq) {
		this.bq = bq;
	}

	@Override
	public void run() {
		//师傅要一直做饼，所以放在循环中
		while(true) {
			//因为饼盘是唯一的，使用它作为对象锁
			synchronized(bq) {
				//饼盘满的时候，师傅休息。
				while(bq.remainingCapacity() == 0) {
					try {
						System.out.println("盘子满了，师傅休息...");
						bq.wait();
					} catch (InterruptedException e) {
						System.out.println("师傅被打断了...");
					}
				}
				//师傅往盘子里放饼
				YongkangMeatWheatCake makedCake = new YongkangMeatWheatCake();
				bq.add(makedCake);
				System.out.println("师傅做了个"+makedCake+"放入盘子中");
				//唤醒因为饼盘空而等到的顾客，和刚来的顾客一起竞争买饼（假装不排队吧(`へ´*)ノ）
				bq.notifyAll();
			}
		}
	}
	
}

/**
 * 消费者
 *
 */
class Customer implements Runnable{
	public static int count = 0;
	private int no;
	/**
	 * 放饼的盘子，消费者从里面拿饼
	 */
	private BlockingQueue<YongkangMeatWheatCake> bq;
	
	/**
	 * 买到的饼
	 */
	private YongkangMeatWheatCake myCake;
	
	public Customer(BlockingQueue<YongkangMeatWheatCake> bq) {
		this.bq = bq;
		no = ++count;
	}
	
	@Override
	public void run() {
		System.out.println(this+"来买饼了...");
		//因为饼盘是唯一的，使用它作为对象锁
		synchronized(bq) {
			System.out.println(this+"准备买饼...");
			//盘子空的时候，客户等待
			while(bq.isEmpty()) {
				try {
					System.out.println("饼盘空了，"+this+"等待...");
					//盘子空的时候，叫醒其他等待的线程，这其中包括师傅，师傅就可以做饼
					bq.notifyAll();
					bq.wait();
				} catch (InterruptedException e) {
					System.out.println("顾客被中断了...");
				}
			}
			myCake = bq.poll();
			System.out.println("哇！"+this+"买到了"+myCake);
			//通知师傅
			bq.notifyAll();
		}
	}

	@Override
	public String toString() {
		return "Customer"+no;
	}
	
}

/**
 * 永康肉麦饼类
 */
class YongkangMeatWheatCake{
	public static int count = 0;
	private int cakeNo;
	public YongkangMeatWheatCake() {
		cakeNo = ++count;
	}

	@Override
	public String toString() {
		return "饼 " + cakeNo;
	}
	
}

