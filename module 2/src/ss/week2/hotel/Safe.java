package ss.week2.hotel;

import ss.week2.hotel.Password;

public class Safe {

	private Password password;
	private boolean active;
	private boolean open;
	
	public Safe() {
		password = new Password();
		active = false;
		open = false;
	}

	//@ invariant isOpen() ==> isActive();
	
	
	//@ ensures getPassword().testWord(password) ==> isActive();
	//@ requires password != null;
	public void activate(String password) {
		assert this.password != null;
		if (this.password.testWord(password)) {
			this.active = true;
		}
	}
	
	//@ ensures !isActive();
	public void deactivate() {
		active = false;
		open = false;
		
	}
	//@ ensures isActive() && getPassword().testWord(password);
	public void open(String password) {
		assert this.password.testWord(password) == true;
		if (this.password.testWord(password) && active == true) {
			open = true;
		}
	}
	
	//@ ensures !isActive();
	public void close() {
		open = false;
	}
	
	/* pure */public boolean isActive() {
		return active;
	}
	
	/* pure */public boolean isOpen() {
		return open;
	}
	/* pure */public Password getPasssword() {
		return password;
	}
	
	public static void main (String[] args) {
		Safe s = new Safe();
		s.activate(null);
	}
		

}
