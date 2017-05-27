package btp.oneP;

public class ThreeFloorException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AA cc = new CC();
		try {
			cc.f();
		} catch (AException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}

}

class AException extends Exception{}
class BException extends AException{}
class CException extends BException{}

class AA{
	public void f() throws AException{
		throw new AException();
	} 
}

class BB extends AA{
	public void f() throws BException{
		throw new BException();
	}
}

class CC extends BB{
	public void f() throws CException{
		throw new CException();
	}
}
