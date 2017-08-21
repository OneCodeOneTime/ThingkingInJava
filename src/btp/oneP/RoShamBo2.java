package btp.oneP;
import static btp.oneP.Outcome.*;
public enum RoShamBo2 implements Competitor<RoShamBo2>{
	PAPER(DRAW,LOSE,WIN),
	SCISSORS(WIN,DRAW,LOSE),
	ROCK(LOSE,WIN,DRAW);
	private Outcome vPAPER,vSCISSORS,vROCK;
	RoShamBo2(Outcome paper,Outcome scissors,Outcome rock){
		this.vPAPER = paper;
		this.vSCISSORS = scissors;
		this.vROCK = rock;
	}
	public Outcome compete(RoShamBo2 it){
		switch(it){
			default:
			case PAPER:return vPAPER;
			case SCISSORS:return vSCISSORS;
			case ROCK:return vROCK;
		}
	}
	public static void main(String[] args) {
		RoShamBo.play(RoShamBo2.class, 20);
	}

}

interface Competitor<T extends Competitor<T>>{
	Outcome compete(T compepitor);
}

class RoShamBo{
	public static <T extends Competitor<T>> void match(T a,T b){
		System.out.println(a + " vs " + b + ": " + a.compete(b));
	}
	public static <T extends Enum<T> & Competitor<T>> void play(Class<T> rsbClass,int size){
		for(int i = 0; i<size;i++){
			match(Enums.random(rsbClass),Enums.random(rsbClass));
		}
	}
}
