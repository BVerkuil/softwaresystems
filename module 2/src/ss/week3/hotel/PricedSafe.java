package ss.week3.hotel;

public class PricedSafe extends ss.week3.hotel.Safe implements Bill.Item{
	
	private double price;
	
	public PricedSafe(double price) {
		super();
		this.price = price;
	}
	
	
	public double getAmount() {
		return this.price;
	}
	
	public String toString() {
		return ""+this.price;
	}
}
