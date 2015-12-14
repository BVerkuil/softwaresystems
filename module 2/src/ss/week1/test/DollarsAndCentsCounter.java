package ss.week1.test;

public class DollarsAndCentsCounter {

	private int dollars;
	private int cents;
	
	public void set (int cents, int dollars){
		this.cents = cents;
		this.dollars = dollars;
	}
	
	public DollarsAndCentsCounter() {
		this.cents = 0;
		this.dollars = 0;
	}
	
	public int dollars() {
		return dollars;
	}
	
	public int cents(){
		return cents;
	}
	
	public void add (int dollars, int cents) {
			this.dollars = this.dollars + dollars + ((this.cents + cents) / 100);
			this.cents = (this.cents + cents) % 100;
		
		}

	
	public void reset() {
		dollars = 0;
		cents = 0;
	}
		
}
