package Chapter21.Concurrency;

public class LiftOff implements Runnable {
	protected int countDown = 10;
	private static int taskCount = 0;
	private final int id = taskCount++;
	public LiftOff() {}
	public LiftOff(int countDown) {
		this.countDown = countDown;
	}
	public String status() {
		return "#" + id +"(" + (countDown>0?countDown:"LiftOff") + "),";
	}
	@Override
	public void run() {
		while(countDown-- > 0) {
			System.out.println(status());
			//��ǰ�̷߳���cpu����ִ��״̬��ɾ���״̬��Ҳ���ǵ�ǰ�̻߳����п����ٴλ�ȡ��cpu
			Thread.yield();
		}
	}
	 public static void main(String[] args) {  
	    new LiftOff().run();
	 }  

}
