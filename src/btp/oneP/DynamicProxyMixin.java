package btp.oneP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class DynamicProxyMixin {

	public static void main(String[] args) {
	}

}

class MixinProxy implements InvocationHandler{
	Map<String,Object> delegatesByMethod;
	public MixinProxy(TwoTuple<Object,Class<?>>...pairs){
		this.delegatesByMethod = new HashMap<String,Object>();
		for(TwoTuple<Object,Class<?>> pair:pairs){
			for(Method m : pair.second.getMethods()){
				String methodName = m.getName();
				if(!this.delegatesByMethod.containsKey(methodName)){
					this.delegatesByMethod.put(methodName, pair.first);
				}
			}
		}
	}
	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		String methodName = method.getName();
		Object delegate = this.delegatesByMethod.get(methodName);
		return method.invoke(delegate, args);
	}
	
	public static Object newInstance(TwoTuple...pairs){
		Class[] interfaces = new Class[pairs.length];
		for(int i=0;i<pairs.length;i++){
			interfaces[i] = (Class) pairs[i].second;
		}
		ClassLoader cl = pairs[0].first.getClass().getClassLoader();
		return Proxy.newProxyInstance(cl, interfaces, new MixinProxy(pairs));
	}
	
	
}


class TwoTuple<K,V>{
	K first;
	V second;
	public TwoTuple(K k,V v){
		this.first = k;
		this.second = v;
	}
}
