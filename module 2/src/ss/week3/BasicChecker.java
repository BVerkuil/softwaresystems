package ss.week3;

public class BasicChecker implements Checker {
	
	public static String INITPASS = "wachtwoord";
	
	public boolean acceptable(String password) {
		return (password.length() > 6 && !password.contains(" "));
	}
	
	public String generatePassword() {
		return INITPASS;
		}
}
