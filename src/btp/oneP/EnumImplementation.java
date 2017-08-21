package btp.oneP;

import java.util.Random;

public class EnumImplementation {
	public static <T> void printNext(GeneratorN<T> rg){
		System.out.println(rg.next() + ", ");
	}
	public static void main(String[] args) {
		CartoonCharacter cc = CartoonCharacter.BOB;
		for(int i = 0;i<10;i++){
			printNext(cc);
		}
	}
	
}

enum CartoonCharacter implements GeneratorN<CartoonCharacter>{
	SLAPPY,SPANKY,PUNCHY,SILLY,BOUNCY,NUTTY,BOB;
	private Random rand = new Random(47);
	@Override
	public CartoonCharacter next() {
		return values()[rand.nextInt(values().length)];
	}
	
}
