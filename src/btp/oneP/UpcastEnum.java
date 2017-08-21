package btp.oneP;

public class UpcastEnum {

	public static void main(String[] args) {
		Search[] vals = Search.values();
		Enum e= Search.HITHER;
		for(Enum en : e.getClass().getEnumConstants()){
			System.out.println(en);
		}
		
		try{
			Class<Integer> intClass = Integer.class;
			for(Object en : intClass.getEnumConstants()){
				System.out.println(en);
			}
		}catch(Exception ee){
			ee.printStackTrace();
		}
	}

}

enum Search{
	HITHER,YON
}
