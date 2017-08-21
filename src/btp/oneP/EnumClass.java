package btp.oneP;

public class EnumClass {

	public static void main(String[] args) {
		for(Shrubbery s : Shrubbery.values()){
			System.out.println(s  + " ordinal:" + s.ordinal());
			System.out.println(s.compareTo(Shrubbery.CRAELING));
			System.out.println(s.equals(Shrubbery.CRAELING));
			System.out.println(s == Shrubbery.CRAELING);
			System.out.println(s.getDeclaringClass());
			System.out.println(s.name());
			System.out.println("--------------------");
		}
		for(String s : "HANGING CRAELING GROUND".split(" ")){
			Shrubbery shurb = Enum.valueOf(Shrubbery.class, s);
			System.out.println(shurb);
		}
	}
	
}

enum Shrubbery{
	GROUND,CRAELING,HANGING;
}
