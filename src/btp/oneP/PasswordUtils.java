package btp.oneP;

import java.util.List;

public class PasswordUtils {
	@UseCase(id = 47,description = "Password must contain at least one numeric")
	public boolean validatePawwword(String password){
		return password.matches("\\w*\\d\\w*");
	}
	
	@UseCase(id = 48)
	public String encryptPawwword(String password){
		return new StringBuilder(password).reverse().toString();
	}
	
	@UseCase(id = 49,description = "new password can't equal previously used ones")
	public boolean checkForNewPassword(List<String> previousPw,String password){
		return !previousPw.contains(password);
	}
}
