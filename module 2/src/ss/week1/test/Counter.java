package ss.week1.test;

public class Counter {

	private int dollars;
	private int cents;
	
	public int dollars() {
		return dollars;
	}
	
	public int cents(){
		return cents;
	}
	
	public void add (int dollars, int cents) {
		this.dollars = this.dollars + dollars;
		this.cents = (this.cents + cents);
	}
	
	public void reset() {
		dollars = 0;
		cents = 0;
	}
		
}
