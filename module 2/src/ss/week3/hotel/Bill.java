package ss.week3.hotel;

import java.io.*;

public class Bill {

	public static interface Item{
			double getAmount();
		}
		
	private PrintStream theOutStream;
	private double sum;
	
	public Bill(PrintStream theOutStream) {
		this.theOutStream = theOutStream;

	}
	public void newItem(Bill.Item item) {
		sum = sum + item.getAmount();
		if( theOutStream != null) {
			theOutStream.printf("\n%-15s %10.2f", item.toString(), item.getAmount());
		}
	}
	
	public void close() {
		theOutStream.printf("\n%-15s %10.2f", "Sum", getSum());
	}
	
	public double getSum() {
		return sum;
	}
//	public static void main(String[] args) {

}
