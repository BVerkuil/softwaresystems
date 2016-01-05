package ss.week6.dictionaryattack;

import java.util.Map;
import java.io.*;
import java.util.*;
import java.security.MessageDigest;
import org.apache.commons.codec.binary.Hex;

public class DictionaryAttack {
	private Map<String, String> passwordMap;
	private Map<String, String> hashDictionary;

	public DictionaryAttack(){
		passwordMap = new HashMap<String, String>();
		hashDictionary = new HashMap<String, String>();
	}
	
    private static final String PATH = "src\\ss\\week6\\test\\"; //Your path to the test folder
	
	/**
	 * Reads a password file. Each line of the password file has the form:
	 * username: encodedpassword
	 * 
	 * After calling this method, the passwordMap class variable should be
	 * filled withthe content of the file. The key for the map should be
	 * the username, and the password hash should be the content.
	 * @param filename
	 */
	public void readPasswords(String filename) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(filename));   
		String line = reader.readLine();
		while(line != null) {
			String[] split = line.split(": ");
			try {
			passwordMap.put(split[0], split[1]);
			} catch (ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
			}
			line = reader.readLine();
		}	
		reader.close();
	}

	/**
	 * Given a password, return the MD5 hash of a password. The resulting
	 * hash (or sometimes called digest) should be hex-encoded in a String.
	 * @param password
	 * @return
	 */
	public String getPasswordHash(String password) {
		String res = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			res = new String(Hex.encodeHex(md.digest(password.getBytes())));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * Checks the password for the user the password list. If the user
	 * does not exist, returns false.
	 * @param user
	 * @param password
	 * @return whether the password for that user was correct.
	 */
	public boolean checkPassword(String user, String password) {
		return passwordMap.get(user).equals(getPasswordHash(password));
	}

	/**
	 * Reads a dictionary from file (one line per word) and use it to add
	 * entries to a dictionary that maps password hashes (hex-encoded) to
     * the original password.
	 * @param filename filename of the dictionary.
	 */
    	public void addToHashDictionary(String filename)throws IOException  {
    		BufferedReader reader = new BufferedReader(new FileReader(filename));   
    		String line = reader.readLine(); 
    		while(line != null) {
    				hashDictionary.put(line, getPasswordHash(line));
    				line = reader.readLine();
    		} 		
    		reader.close();
    }
	/**
	 * Do the dictionary attack.
	 */
	public void doDictionaryAttack() throws IOException {
		addToHashDictionary(PATH + "Passwords.txt");
		readPasswords(PATH + "LeakedPasswords.txt");
		for(String user : passwordMap.keySet()) {
			for(String pass : hashDictionary.keySet()) {
				if (passwordMap.get(user).equals(getPasswordHash(pass))) {
					System.out.println("Wachtwoord van User: " + user + " is: " + pass + "." );
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		DictionaryAttack da = new DictionaryAttack();
		// To implement
		da.doDictionaryAttack();
	}

}
