package btp.oneP;

import java.util.ArrayList;
import java.util.Random;

public class GenericMain {

	public static void main(String[] args) {
		MaskedBall maskedBall = new MaskedBall();
		//
		maskedBall.join(new ScienceBigShot());
		maskedBall.join(new GovernmtBigShot());
		//返回一个舞会的人要显式转型
		maskedBall.aPlay().play();
	}

}

//面具舞会类
class MaskedBall<T extends MaskPlayer> extends ArrayList<T>{
	private Random rd = new Random(24);
	public void join(T mp){
		//检查身份，只有是有邀请函的（MaskPlayer）的人才能进去，现在编译器自己就会帮我们进行类型检查
		this.add(mp);
		mp.play();
	}
	//随机返回一名舞者
	public T aPlay(){
		return this.get(rd.nextInt(this.size()));
	}
	
}

//参加舞会的人
class MaskPlayer{
	private String name;
	
	public MaskPlayer(){
		this.name = "无名";
	}
	
	
	public String getName() {
		return name;
	}
	
	public void play(){
		System.out.println("忘记烦恼，尽情玩");
	}
}

class ScienceBigShot extends MaskPlayer{
	private String source;
	public ScienceBigShot(){
		this.source = "科技大咖";
	}
	public String getSource() {
		return source;
	}
	public void play(){
		System.out.println(this.source+"(无名)忘记烦恼，尽情玩");
	}
}

class GovernmtBigShot extends MaskPlayer{
	private String source;
	public GovernmtBigShot(){
		this.source = "政府大咖";
	}
	public String getSource() {
		return source;
	}
	public void play(){
		System.out.println(this.source+"(无名)忘记烦恼，尽情玩");
	}

}










