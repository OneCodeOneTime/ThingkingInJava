package btp.oneP;

public class CleanupIdiom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NeedsCleanup nc1 = new NeedsCleanup();
		try{
			
		}finally{
			nc1.dispose();
		}
		
		NeedsCleanup nc2 = new NeedsCleanup();
		NeedsCleanup nc3 = new NeedsCleanup();
		
		try{
			
		}finally{
			nc2.dispose();
			nc3.dispose();
		}
		
		try {
			NeedsCleanup2 nc21 = new NeedsCleanup2();
			try{
				NeedsCleanup2 nc22 = new NeedsCleanup2();
				try{
					
				}finally{
					nc22.dispose();
				}
			}catch(ConstructionException e){
				System.out.println("nc22创建失败");
			}finally{
				nc21.dispose();
			}
		} catch (ConstructionException e) {
			System.out.println("nc21创建失败");
		}
	}

}

class NeedsCleanup{
	private static long counter = 1;
	private final long id = counter++;
	public void dispose(){
		System.out.println("NeedsCleanup "+id+" disposed");
	}
}

class ConstructionException extends Exception{}

class NeedsCleanup2 extends NeedsCleanup{
	public NeedsCleanup2() throws ConstructionException{}
}
