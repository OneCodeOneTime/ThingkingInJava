package btp.oneP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NullRobot {
	public static Robot newNullRobot(Class<? extends Robot> type){
		return (Robot) Proxy.newProxyInstance(Robot.class.getClassLoader(), new Class[]{Null.class, Robot.class},
				new NullRobotProxyHandler(type));
	}
	public static void main(String[] args) {
		//Robot.Test.test(new SnowRemovalRobot("Slusher"));
		Robot[] bots = {
			new SnowRemovalRobot("SnowBee"),
			newNullRobot(SnowRemovalRobot.class)
		};
		for(Robot robot:bots){
			Robot.Test.test(robot);
		}
	}

}

interface Null{}
interface Operation{
	String description();
	void command();
}
interface Robot{
	String name();
	String model();
	List<Operation> oprations();
	class Test{
		public static void test(Robot r){
			if(r instanceof Null){
				System.out.println("[Null Robot]");
			}
			System.out.println("Robot name:"+r.name());
			System.out.println("Robot model:"+r.model());
			for(Operation opration:r.oprations()){
				System.out.println(opration.description());
				opration.command();
			}
		}
	}
}

class SnowRemovalRobot implements Robot{
	private String name;
	public SnowRemovalRobot(String name){this.name = name;}
	@Override
	public String name() {
		return name;
	}

	@Override
	public String model() {
		return "SnowBot Series 11";
	}

	@Override
	public List<Operation> oprations() {
		return Arrays.asList(
					new Operation(){

						@Override
						public String description() {
							return name+" can shovel snow";
						}

						@Override
						public void command() {
							System.out.println(name+" shoveling snow");
						}
						
					},
					new Operation(){

						@Override
						public String description() {
							return name+" can chip ice";
						}

						@Override
						public void command() {
							System.out.println(name+" chipping ice");
						}
						
					},
					new Operation(){

						@Override
						public String description() {
							return name+" can clear the roof";
						}

						@Override
						public void command() {
							System.out.println(name +" clearing roof");
						}
						
					}
		);
	}
	
}



class NullRobotProxyHandler implements InvocationHandler{
	private String nullName;
	private Robot proxied = new NRobot();
	NullRobotProxyHandler(Class<? extends Robot> type){
		nullName = type.getSimpleName()+" NullRobot";
	}
	private class NRobot implements Null,Robot{

		@Override
		public String name() {
			return nullName;
		}

		@Override
		public String model() {
			return nullName;
		}

		@Override
		public List<Operation> oprations() {
			return Collections.emptyList();
		}
		
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return method.invoke(proxied, args);
	}
	
}