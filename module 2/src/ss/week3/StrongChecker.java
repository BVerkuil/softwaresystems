package ss.week3;

public class StrongChecker extends BasicChecker {
	
	public static String INITPASS = "wachtwoord123";
	
	public boolean acceptable(String password) {
		return (super.acceptable(password) && Character.isDigit((password.charAt(password.length() - 1))) && Character.isLetter((password.charAt(0))));
	}
	
	public String generatePassword() {
		return INITPASS;
		}
}
