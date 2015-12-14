package ss.week1.test;

public class Password {

	public static String INITIAL = "pwoord";
	private String password; 
	
	public Password() {
		password = INITIAL;
	}
	
	public boolean acceptable(String suggestion) {
		if (suggestion.length() > 6 && !suggestion.contains(" ")) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean testWord(String test) {
		if (test.equals(password)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean setWord(String oldpass, String newpass) {
		if (oldpass.equals(INITIAL) && acceptable(newpass)) {
			password = newpass;
			return true;
		} else {
			return false;
		}
	}
	
}
