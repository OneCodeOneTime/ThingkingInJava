package Chapter21.Concurrency;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExchangeDemo {
	static int size = 10;
	static int delay = 5;
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService exe = Executors.newCachedThreadPool();
		Exchanger<List<Fat>> xc = new Exchanger<List<Fat>>();
		List<Fat> productor = new CopyOnWriteArrayList<Fat>(),
				comsumer = new CopyOnWriteArrayList<Fat>();
		exe.execute(new ExchangeProductor<Fat>(xc,productor,Fat.class));
		exe.execute(new ExchangerConsumer<Fat>(xc,comsumer));
		TimeUnit.SECONDS.sleep(delay);
		exe.shutdownNow();
	}

}


class ExchangeProductor<T> implements Runnable{
	private Exchanger<List<T>> exchanger;
	private List<T> holder;
	private Class<T> clazz;
	ExchangeProductor(Exchanger<List<T>> exchanger,List<T> holder,Class<T> clazz){
		this.exchanger = exchanger;
		this.holder = holder;
		this.clazz = clazz;
	}
	
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				for(int i=0;i<ExchangeDemo.size;i++) {
					holder.add(clazz.newInstance());
				}
				holder = exchanger.exchange(holder);
			}
		}catch(InterruptedException e) {
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

class ExchangerConsumer<T> implements Runnable{
	private Exchanger<List<T>> exchanger;
	private List<T> holder;
	private volatile T value;
	ExchangerConsumer(Exchanger<List<T>> exchanger,List<T> holder){
		this.exchanger = exchanger;
		this.holder = holder;
	}
	
	@Override
	public void run() {
		while(!Thread.interrupted()) {
			try {
				holder = exchanger.exchange(holder);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(T t:holder) {
				value = t;
				holder.remove(t);
			}
		}
		System.out.println("Final value:"+value);
	}
	
}