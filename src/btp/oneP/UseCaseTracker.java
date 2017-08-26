package btp.oneP;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UseCaseTracker {
	public static void trackUseCases(List<Integer> userCases,Class<?> cl){
		for(Method m : cl.getDeclaredMethods()){
			UseCase uc = m.getAnnotation(UseCase.class);
			if(null != uc){
				System.out.println("Found use case:" + uc.id() + " " + uc.description());
				userCases.remove(new Integer(uc.id()));
			}
		}
		for(int i : userCases){
			System.out.println("Warning:Missing use cases:"+i);
		}
	}
	public static void main(String[] args) {
		List<Integer> useCases = new ArrayList<Integer>();
		Collections.addAll(useCases, 47,48,49,50);
		trackUseCases(useCases,PasswordUtils.class);
	}

}
