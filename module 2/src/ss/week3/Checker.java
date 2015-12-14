package ss.week3;

public interface Checker {
	
	// Should return true if the password is acceptable using the criteria.
	public boolean acceptable(String password);
	
	//returns acceptable String
	public String generatePassword();
}
