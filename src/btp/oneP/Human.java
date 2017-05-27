package btp.oneP;

public class Human {

	public static void main(String[] args) {
		try{
			throw new Sneeze();
		}catch(Sneeze e){
			System.out.println("Sneeze");
		}catch(Annoyance e){
			System.out.println("Annoyance");
		}finally{
			
		}
		
		try{
			throw new Sneeze();
		}catch(Annoyance e){
			System.out.println("Annoyance");
		}finally{
			
		}
		
		try{
			throw new Sneeze();
		}catch(Annoyance e){
			System.out.println("Annoyance");
		}/*catch(Sneeze e){
			System.out.println("Sneeze");
		}*/finally{
			
		}

	}

}

class Annoyance extends Exception{}
class Sneeze extends Annoyance{}
