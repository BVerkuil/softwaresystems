package ss.week3.hotel;

public class SimpleItem implements Bill.Item {

	public String text;
	public double amount;
	
	public SimpleItem(String text, double amount) {
		this.text = text;
		this.amount = amount;
	}
	
	public double getAmount() {
		return this.amount;
	}
	
	public String toString() {
		return this.text;
	}
}
