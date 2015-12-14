package ss.week3;

import java.io.PrintStream;

public class OutStreamTest {
	
	
	public static void main(String[] args) {
		PrintStream theOutStream = new PrintStream(System.out);
		theOutStream.println("123");
		theOutStream.print("123");
	}
	
}
