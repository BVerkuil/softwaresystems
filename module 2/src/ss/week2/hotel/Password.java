package ss.week2.hotel;

import  ss.week3.*;

public class Password {

	private Checker checker;
	private String factoryPassword; 
	
	public static String INITIAL = "wachtwoord";
	private String password; 
	
	public Password(Checker checker) {
		this.checker = checker;
		factoryPassword = checker.generatePassword();
	}
	
	public Password() {
		this(new BasicChecker());
	}
	
	
	public boolean acceptable(String suggestion) {
		return (suggestion.length() > 6 && !suggestion.contains(" "));
	}
	
	public boolean testWord(String test) {
		return test.equals(password);
	}
	
	public boolean setWord(String oldpass, String newpass) {
		if (oldpass.equals(INITIAL) && acceptable(newpass)) {
			password = newpass;
			return true;
		} else {
			return false;
		}
	}
	
	public String getfactoryPassword() {
		return INITIAL;
	}
}
