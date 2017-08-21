package btp.oneP;

public class RandomTest {

	public static void main(String[] args) {
		for(int i = 0; i < 20 ; i++){
			System.out.print(Enums.random(Activity.class) + " ");
		}
	}

}

enum Activity{
	SITTING,LYING,STANING,HOPPONG,RUNNING,DOGGING,JUMPING,FALLING,FLYING
}
