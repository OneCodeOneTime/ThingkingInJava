package btp.oneP;

import java.util.ArrayList;
import java.util.Random;

public class GenericMain {

	public static void main(String[] args) {
		MaskedBall maskedBall = new MaskedBall();
		//
		maskedBall.join(new ScienceBigShot());
		maskedBall.join(new GovernmtBigShot());
		//����һ��������Ҫ��ʽת��
		maskedBall.aPlay().play();
	}

}

//��������
class MaskedBall<T extends MaskPlayer> extends ArrayList<T>{
	private Random rd = new Random(24);
	public void join(T mp){
		//�����ݣ�ֻ���������뺯�ģ�MaskPlayer�����˲��ܽ�ȥ�����ڱ������Լ��ͻ�����ǽ������ͼ��
		this.add(mp);
		mp.play();
	}
	//�������һ������
	public T aPlay(){
		return this.get(rd.nextInt(this.size()));
	}
	
}

//�μ�������
class MaskPlayer{
	private String name;
	
	public MaskPlayer(){
		this.name = "����";
	}
	
	
	public String getName() {
		return name;
	}
	
	public void play(){
		System.out.println("���Ƿ��գ�������");
	}
}

class ScienceBigShot extends MaskPlayer{
	private String source;
	public ScienceBigShot(){
		this.source = "�Ƽ���";
	}
	public String getSource() {
		return source;
	}
	public void play(){
		System.out.println(this.source+"(����)���Ƿ��գ�������");
	}
}

class GovernmtBigShot extends MaskPlayer{
	private String source;
	public GovernmtBigShot(){
		this.source = "������";
	}
	public String getSource() {
		return source;
	}
	public void play(){
		System.out.println(this.source+"(����)���Ƿ��գ�������");
	}

}










