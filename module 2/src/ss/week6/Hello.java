package ss.week6;

import java.util.Scanner;

public class Hello {
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean result = true;
		while(result) {
			System.out.print("Wat is uw naam? ");
			String answer = in.nextLine();
			if(answer.equals("")) {
				result = false;
				System.exit(0);
			} else {
				System.out.println("Hello " + answer);
			}

		}
		in.close();
	}
}
