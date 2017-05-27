package btp.oneP;

import java.util.ArrayList;
import java.util.Collection;

public class GenericEvaluate {

	public static void main(String[] args) {
		Collection<Pair<String,Long>> c1 = new ArrayList<Pair<String,Long>>();
		Collection<Pair<String,Long>> c2 = c1;
		//Collection<Pair<String,?>> c3 = c1;
		Collection<? extends Pair<String,?>> c4 = c1;
		
		Collection<SubTypeOfPair<String,Long>> c5 = new ArrayList<SubTypeOfPair<String,Long>>();
		//Collection<Pair<String,Long>> c6 = c5;
		Collection<SubTypeOfPair<String,Long>> c7 = c5;
		//Collection<Pair<String,?>> c8 = c5;
		Collection<? extends Pair<String,?>> c9 = c5;
	}

}

class Pair<K,V>{
	
}

class SubTypeOfPair<K,V> extends Pair<K, V>{
	
}
