package btp.oneP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyForInterfaces {

	public static void main(String[] args) {
		//���������ί����
		Mp3 mp3 = new Mp3();
		Mobile mobile = new Mobile();
		Mp3 sonyMp3 = new SonyMp3();
		Mobile iphone = new Iphone();
		//1.ʹ�����ֲ��Ŵ�������ȡmp3�ķ���
		/*
		 * ����˵����
		 * ��һ�����������������һ��ʹ������Ҫ�ķ�����Ǹ��ӿڵļ���������
		 * �ڶ������������ȡ�ķ�����б����ӿ��б�����mp3�ķ����б����Music������һ��
		 * �������������ǵ��ô�����������һ������ί����ĵ��ô�����
		 * �������ʽת����˵����������ɵĶ�̬����ʵ���˵ڶ��������Ľӿڣ����������ṩ��Щ�ӿڵķ���
		 */
		Music music = (Music)Proxy.newProxyInstance(Music.class.getClassLoader(), mp3.getClass().getInterfaces(), 
				new MusicInvocationHandler(mp3));
		//�����ί����mp3�ڵķ���
		music.listenMusic();
		
		System.out.println("--------------------------");
		
		//����һ��ֻ�벥�ŵ�Ӱ�İ����ֻ������������ֲ��Ź���
		Movie movie = (Movie)Proxy.newProxyInstance(Movie.class.getClassLoader(), new Class[]{Movie.class}, 
				new MovieInvocationHandler(mobile));
		movie.seeMovie();
		
		System.out.println("--------------------------");
		//���������ͻᱨ��ClassCastException���ڶ��������в�û��Music�������Բ����ṩ
		/*music = (Music)Proxy.newProxyInstance(Movie.class.getClassLoader(), new Class[]{Movie.class}, 
				new MovieInvocationHandler(mobile));
		music.listenMusic();*/
		
		/*�ڶ���������������ַ�������ֻ��Ϳ��Բ��������ˣ����ǵ��ô�����ʹ�õ��ǵ�Ӱ���ô����������ӡ��
			before see a movie...
			...now begin music with mobile
			after see a movie...
		*���Դ�ʱ���ô�����Ҳ��Ҫ����
		*/
		/*music = (Music)Proxy.newProxyInstance(Movie.class.getClassLoader(), new Class[]{Movie.class,Music.class}, 
				new MovieInvocationHandler(mobile));
		music.listenMusic();
		System.out.println("--------------------------");*/
		
		//ʹ������mp3��������
		music = (Music)Proxy.newProxyInstance(Mp3.class.getClassLoader(), Mp3.class.getInterfaces(), 
				new Mp3InvocationHandler(sonyMp3));
		music.listenMusic();
		System.out.println("--------------------------");
		
		//ʹ��iphone��������
		music = (Music)Proxy.newProxyInstance(mobile.getClass().getClassLoader(), Mobile.class.getInterfaces(), 
				new MobileInvocationHandler(iphone));
		music.listenMusic();
		System.out.println("--------------------------");
		
		//ʹ��iphone����Ӱ
		movie = (Movie)Proxy.newProxyInstance(Mobile.class.getClassLoader(), Mobile.class.getInterfaces(),
				new MobileInvocationHandler(iphone));
		movie.seeMovie();
	}

}

/*
 * ��̬������һ��ʵ����һ�������ӿڵľ���ί���࣬
 * ͨ�������ཫ���������͵��н���ô��������н��ٸ��ݾ���ί��������ͽ��о��巽���ĵ���
 */




/*����ί����ʹ�����Ҫʵ�ֵ�ģ��ӿ�--begin*/
//�������ֵĹ��ܽӿ�
interface Music{
	void listenMusic();
}
//������Ӱ�Ĺ��ܽӿ�
interface Movie{
	void seeMovie();
}
/*����ί����ʹ�����Ҫʵ�ֵ�ģ��ӿ�--end*/





/*�����ί���ࣺ�������ṩ�����񡱵���--begin*/

//�����Բ������ֵ�mp3��
class Mp3 implements Music{

	@Override
	public void listenMusic() {
		System.out.println("...now begin music with mp3");
	}
}

//���ȿ���������Ҳ���Կ���Ƶ���ֻ���
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
/*�����ί���ࣺ�������ṩ�����񡱵���--end*/




/*�������ί���࣬����mp3��������Sony�����ӣ��ֻ���iphone����--begin*/
class SonyMp3 extends Mp3{
	@Override
	public void listenMusic() {
		System.out.println("...now begin music with SonyMp3");
	}
}

class Iphone extends Mobile{
	@Override
	public void seeMovie() {
		System.out.println("...now begin movie(װ��) with Iphone");
	}

	@Override
	public void listenMusic() {
		System.out.println("...now begin music(װ��) with Iphone");
	}
}
/*�������ί���࣬����mp3��������Snoy�����ӣ��ֻ���iphone����--begin*/





/*���ô����������Դ���ķ������÷ַ���������ί���࣬�ö�Ӧ��ί�����ṩ����--begin*/

// @���Խ������ֲ��ŷ���ַ��ĵ��ô�����
class MusicInvocationHandler implements InvocationHandler{
	//ί�����ʵ������
	private Music music;
	public MusicInvocationHandler(Music music){
		this.music = music;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		/*�����ĺ��壺
		 *proxy�����������
		 *method��Ҫִ�еķ���
		 *args�������Ĳ���
		*/
		//���ֲ���ǰ������һЩ����������
		System.out.println("before listen music...");
		//��������
		method.invoke(music, args);
		//���ֲ��ź�Ҳ������һЩ����
		System.out.println("after listen music...");
		return null;
	}
	
}

//@ ���Խ�����Ƶ���ŷ���ַ��ĵ��ô�����
class MovieInvocationHandler implements InvocationHandler{
	//ί�����ʵ������
	private Movie movie;
	public MovieInvocationHandler(Movie movie){
		this.movie = movie;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		/*�����ĺ��壺
		 *proxy�����������
		 *method��Ҫִ�еķ���
		 *args�������Ĳ���
		*/
		//��Ƶ����ǰ������һЩ����������
		System.out.println("before see a movie...");
		//������Ƶ
		method.invoke(movie, args);
		//��Ƶ���ź�Ҳ������һЩ����
		System.out.println("after see a movie...");
		return null;
	}
	
}

//��ȻҲ���Բ��������ķ�����д���ô��������������������mp3�����ֻ���д���ô���������ֻ�Ǽ̳����Ĳ�����⣬������������
//@ ����mp3�ĵ��ô�����
class Mp3InvocationHandler implements InvocationHandler{
	//ί�����ʵ������
	private Mp3 mp3;
	public Mp3InvocationHandler(Mp3 mp3){
		this.mp3 = mp3;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		/*�����ĺ��壺
		 *proxy�����������
		 *method��Ҫִ�еķ���
		 *args�������Ĳ���
		*/
		//ʹ��mp3ǰ������һЩ����������
		System.out.println("before use mp3...");
		//��������
		method.invoke(mp3, args);
		//ʹ��mp3�������һЩ����������
		System.out.println("after use mp3...");
		return null;
	}
	
}

//@ ����mobile�ĵ��ô�����
class MobileInvocationHandler implements InvocationHandler{
	//ί�����ʵ������
	private Mobile mobile;
	public MobileInvocationHandler(Mobile mobile){
		this.mobile = mobile;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		/*�����ĺ��壺
		 *proxy�����������
		 *method��Ҫִ�еķ���
		 *args�������Ĳ���
		*/
		//ʹ���ֻ�ǰ������һЩ����������
		System.out.println("before use mobile...");
		//������Ƶ
		method.invoke(mobile, args);
		//ʹ���ֻ���Ҳ������һЩ����
		System.out.println("after use mobile...");
		return null;
	}
	
}

/*���ô����������Դ���ķ������÷ַ���������ί���࣬�ö�Ӧ��ί�����ṩ����--end*/
