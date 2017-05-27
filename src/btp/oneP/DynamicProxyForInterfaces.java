package btp.oneP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyForInterfaces {

	public static void main(String[] args) {
		//创建具体的委托类
		Mp3 mp3 = new Mp3();
		Mobile mobile = new Mobile();
		Mp3 sonyMp3 = new SonyMp3();
		Mobile iphone = new Iphone();
		//1.使用音乐播放处理器获取mp3的服务
		/*
		 * 参数说明：
		 * 第一个参数是类加载器，一般使用你需要的服务的那个接口的加载器即可
		 * 第二参数是你想获取的服务的列表，即接口列表，比如mp3的服务列表就是Music音乐这一个
		 * 第三个参数就是调用处理器，构造一个具体委托类的调用处理器
		 * 这里的显式转换，说明了这个生成的动态代理实现了第二个参数的接口，即它可以提供这些接口的服务
		 */
		Music music = (Music)Proxy.newProxyInstance(Music.class.getClassLoader(), mp3.getClass().getInterfaces(), 
				new MusicInvocationHandler(mp3));
		//会调用委托类mp3内的方法
		music.listenMusic();
		
		System.out.println("--------------------------");
		
		//这是一个只想播放电影的傲娇手机，放弃了音乐播放功能
		Movie movie = (Movie)Proxy.newProxyInstance(Movie.class.getClassLoader(), new Class[]{Movie.class}, 
				new MovieInvocationHandler(mobile));
		movie.seeMovie();
		
		System.out.println("--------------------------");
		//下面这样就会报错：ClassCastException，第二个参数中并没有Music服务，所以不能提供
		/*music = (Music)Proxy.newProxyInstance(Movie.class.getClassLoader(), new Class[]{Movie.class}, 
				new MovieInvocationHandler(mobile));
		music.listenMusic();*/
		
		/*第二个参数里加了音乐服务，这个手机就可以播放音乐了，但是调用处理器使用的是电影调用处理器，会打印出
			before see a movie...
			...now begin music with mobile
			after see a movie...
		*所以此时调用处理器也需要更改
		*/
		/*music = (Music)Proxy.newProxyInstance(Movie.class.getClassLoader(), new Class[]{Movie.class,Music.class}, 
				new MovieInvocationHandler(mobile));
		music.listenMusic();
		System.out.println("--------------------------");*/
		
		//使用索尼mp3播放音乐
		music = (Music)Proxy.newProxyInstance(Mp3.class.getClassLoader(), Mp3.class.getInterfaces(), 
				new Mp3InvocationHandler(sonyMp3));
		music.listenMusic();
		System.out.println("--------------------------");
		
		//使用iphone播放音乐
		music = (Music)Proxy.newProxyInstance(mobile.getClass().getClassLoader(), Mobile.class.getInterfaces(), 
				new MobileInvocationHandler(iphone));
		music.listenMusic();
		System.out.println("--------------------------");
		
		//使用iphone看电影
		movie = (Movie)Proxy.newProxyInstance(Mobile.class.getClassLoader(), Mobile.class.getInterfaces(),
				new MobileInvocationHandler(iphone));
		movie.seeMovie();
	}

}

/*
 * 动态代理是一个实现了一个或多个接口的具体委托类，
 * 通过代理类将方法请求发送到中介调用处理器，中介再根据具体委托类的类型进行具体方法的调用
 */




/*具体委托类和代理类要实现的模板接口--begin*/
//·听音乐的功能接口
interface Music{
	void listenMusic();
}
//·看电影的功能接口
interface Movie{
	void seeMovie();
}
/*具体委托类和代理类要实现的模板接口--end*/





/*具体的委托类：即真正提供“服务”的类--begin*/

//·可以播放音乐的mp3类
class Mp3 implements Music{

	@Override
	public void listenMusic() {
		System.out.println("...now begin music with mp3");
	}
}

//·既可以听音乐也可以看视频的手机类
class Mobile implements Music,Movie{

	@Override
	public void seeMovie() {
		System.out.println("...now begin movie with mobile");
	}

	@Override
	public void listenMusic() {
		System.out.println("...now begin music with mobile");
	}
	
}
/*具体的委托类：即真正提供“服务”的类--end*/




/*更具体的委托类，比如mp3下有索尼Sony的牌子，手机有iphone牌子--begin*/
class SonyMp3 extends Mp3{
	@Override
	public void listenMusic() {
		System.out.println("...now begin music with SonyMp3");
	}
}

class Iphone extends Mobile{
	@Override
	public void seeMovie() {
		System.out.println("...now begin movie(装逼) with Iphone");
	}

	@Override
	public void listenMusic() {
		System.out.println("...now begin music(装逼) with Iphone");
	}
}
/*更具体的委托类，比如mp3下有索尼Snoy的牌子，手机有iphone牌子--begin*/





/*调用处理器：将对代理的方法调用分发到真正的委托类，让对应的委托类提供服务--begin*/

// @可以进行音乐播放服务分发的调用处理器
class MusicInvocationHandler implements InvocationHandler{
	//委托类的实例对象
	private Music music;
	public MusicInvocationHandler(Music music){
		this.music = music;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		/*参数的含义：
		 *proxy：代理类对象
		 *method：要执行的方法
		 *args：方法的参数
		*/
		//音乐播放前可以做一些你想做的事
		System.out.println("before listen music...");
		//播放音乐
		method.invoke(music, args);
		//音乐播放后也可以做一些事情
		System.out.println("after listen music...");
		return null;
	}
	
}

//@ 可以进行视频播放服务分发的调用处理器
class MovieInvocationHandler implements InvocationHandler{
	//委托类的实例对象
	private Movie movie;
	public MovieInvocationHandler(Movie movie){
		this.movie = movie;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		/*参数的含义：
		 *proxy：代理类对象
		 *method：要执行的方法
		 *args：方法的参数
		*/
		//视频播放前可以做一些你想做的事
		System.out.println("before see a movie...");
		//播放视频
		method.invoke(movie, args);
		//视频播放后也可以做一些事情
		System.out.println("after see a movie...");
		return null;
	}
	
}

//当然也可以不面向具体的服务来写调用处理器，比如你就想面向mp3或者手机来写调用处理器，这只是继承树的层次问题，看具体需求了
//@ 面向mp3的调用处理器
class Mp3InvocationHandler implements InvocationHandler{
	//委托类的实例对象
	private Mp3 mp3;
	public Mp3InvocationHandler(Mp3 mp3){
		this.mp3 = mp3;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		/*参数的含义：
		 *proxy：代理类对象
		 *method：要执行的方法
		 *args：方法的参数
		*/
		//使用mp3前可以做一些你想做的事
		System.out.println("before use mp3...");
		//播放音乐
		method.invoke(mp3, args);
		//使用mp3后可以做一些你想做的事
		System.out.println("after use mp3...");
		return null;
	}
	
}

//@ 面向mobile的调用处理器
class MobileInvocationHandler implements InvocationHandler{
	//委托类的实例对象
	private Mobile mobile;
	public MobileInvocationHandler(Mobile mobile){
		this.mobile = mobile;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		/*参数的含义：
		 *proxy：代理类对象
		 *method：要执行的方法
		 *args：方法的参数
		*/
		//使用手机前可以做一些你想做的事
		System.out.println("before use mobile...");
		//播放视频
		method.invoke(mobile, args);
		//使用手机后也可以做一些事情
		System.out.println("after use mobile...");
		return null;
	}
	
}

/*调用处理器：将对代理的方法调用分发到真正的委托类，让对应的委托类提供服务--end*/
