package btp.oneP;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

	public static void main(String[] args) {
		String password = "aaaa333fd%";
		String regEx = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).{8,}";
		Pattern pattern = Pattern.compile(regEx);
		Matcher match = pattern.matcher(password);
		boolean isMatch = match.matches();
		System.out.println(isMatch);
	}

}
