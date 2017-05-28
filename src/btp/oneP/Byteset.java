package btp.oneP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Byteset {
	Byte[] possibles = {1,2,3,4,5,6,7,8,9};
	Set<Byte> myset = new HashSet<Byte>(Arrays.asList(possibles));
	
	Set<Byte> myset2 = new HashSet<Byte>(Arrays.<Byte>asList(new Byte[]{1,2,3,4,5,6,7,8,9}));
	//The parameterized method <Byte>asList(Byte...) of type Arrays is not applicable for the arguments (Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer)
	//Set<Byte> myset3 = new HashSet<Byte>(Arrays.<Byte>asList(1,2,3,4,5,6,7,8,9));
}
