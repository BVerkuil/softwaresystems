package ss.week3;

public class Format {

	public static void printLine(String text, double amount) {
		System.out.printf("\n%-15s %10.2f", text, amount); 
	}
	
	public static void main(String[] args) {
		printLine("fiets", 0.32);
		printLine("s", 0.23);
		printLine("pino", -1.3212123);
	}
}
