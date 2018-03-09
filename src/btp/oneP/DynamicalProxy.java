package btp.oneP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicalProxy {

	public static void main(String[] args) {
		Fly fly = (Fly)Proxy.newProxyInstance(RealFly.class.getClassLoader(), new Class[] {Fly.class}, new ProxyImpl(new RealFly()));
		fly.fly();
	}

	
	interface Fly{
		void fly();
	}
	static class RealFly implements Fly{

		@Override
		public void fly() {
			System.out.println("flying...");
		}
		
	}
	static class ProxyImpl implements InvocationHandler{
		Fly fly;
		public ProxyImpl(Fly fly){
			this.fly = fly;
		}
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			System.out.println("before");
			method.invoke(fly, args);
			System.out.println("after");
			return null;
		}
		
	}
}
