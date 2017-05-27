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

//ί����Ĺ�����
interface Server{
	void privateServer();
	void publicServer();
}

//ί����
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

//���������
class ServerHandler implements InvocationHandler{
	//�����ί����
	private Server server;
	public ServerHandler(Server server){
		this.server = server;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//����ִ��ǰ���Խ���һЩ����
		System.out.println("before server...");
		method.invoke(server, args);
		//����ִ�к���Խ���һЩ����
		System.out.println("after server...");
		return null;
	}
	
}
