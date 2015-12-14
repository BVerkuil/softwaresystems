package ss.week3.hotel;

public class PricedRoom extends ss.week3.hotel.Room implements Bill.Item {

	private double RoomPrice;
	private int SafePrice;
	
	public PricedRoom(int RoomNumber, double RoomPrice, int SafePrice) {
		super(RoomNumber, new PricedSafe(SafePrice)); 
		this.RoomPrice = RoomPrice;
		
	}
	public double getAmount() {
		return RoomPrice+SafePrice;
	}
	
	public String toString() {
		return super.toString()+(this.RoomPrice+this.SafePrice);
	}
}
