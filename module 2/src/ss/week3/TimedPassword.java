package ss.week3;

public class TimedPassword extends ss.week2.hotel.Password {

	public int validtime;
	public long tStart;
	public long tEnd;
	
	public static int DEFAULTTIME = 2;
	
	public TimedPassword(int validtime) {
		this.validtime = validtime * 1000;
		tStart = System.currentTimeMillis();
	}
	
	public TimedPassword() {
		this(DEFAULTTIME);
	}

	
	public boolean isExpired() {
		tEnd = System.currentTimeMillis();
		return !((tEnd - tStart) < validtime);
	}

	public boolean setWord(String oldpass, String newpass) {
		if (super.setWord(oldpass, newpass)) {
			tStart = System.currentTimeMillis();
			return true;
		} else {
			return false;
		}
	}
}