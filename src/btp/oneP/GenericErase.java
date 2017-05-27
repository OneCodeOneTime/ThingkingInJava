package btp.oneP;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class GenericErase {

	public static void main(String[] args) {
		ArrayList<String> sl = new ArrayList<String>();
		sl.add("Magic");
		Class<? extends ArrayList> clazz = sl.getClass();
		try{
			Method method = clazz.getMethod("add", Object.class);
			method.invoke(sl, 1);
			System.out.println(sl);
			//out:[Magic, 1]
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
