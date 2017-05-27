package btp.oneP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyDynamicProxy {

	public static void main(String[] args) {
		Server s =(Server)Proxy.newProxyInstance(Server.class.getClassLoader(), SpecificServer.class.getInterfaces(), new ServerHandler(new SpecificServer()));
		s.privateServer();
		s.publicServer();
	}

}

//委托类的公共类
interface Server{
	void privateServer();
	void publicServer();
}

//委托类
class SpecificServer implements Server{
	@Override
	public void privateServer() {
		System.out.println("...my private Server...");
	}
	@Override
	public void publicServer() {
		System.out.println("...my public Server...");
	}
}

//代理调用器
class ServerHandler implements InvocationHandler{
	//具体的委托类
	private Server server;
	public ServerHandler(Server server){
		this.server = server;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//方法执行前可以进行一些操作
		System.out.println("before server...");
		method.invoke(server, args);
		//方法执行后可以进行一些操作
		System.out.println("after server...");
		return null;
	}
	
}
