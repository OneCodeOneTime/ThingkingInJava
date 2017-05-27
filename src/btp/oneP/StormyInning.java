package btp.oneP;

public class StormyInning extends Inning implements Storm{
	public StormyInning() throws RainedOut,BaseballException{}
	public StormyInning(String s) throws Foul,BaseballException{}
	
	public void walk(){}
	public void event() throws PopFoul{}
	public static void main(String[] args) {
		

	}

	@Override
	public void rainHard() throws RainedOut {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atBat() throws PopFoul {
		// TODO Auto-generated method stub
		
	}

}

class BaseballException extends Exception{}

class Foul extends BaseballException{}

class Strike extends BaseballException{}

abstract class Inning{
	public Inning() throws BaseballException{}
	public void event() throws PopFoul{}
	
	public abstract void atBat() throws Strike,Foul;
	public void walk(){}
}

class StromException extends Exception{}

class RainedOut extends StromException{}

class PopFoul extends Foul{}

interface Storm{
	public void event() throws Foul;
	public void rainHard() throws RainedOut;
}
