package ss.week6;

import java.util.Scanner;

public class Words {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		boolean result = true;
		
		//Make array of input words
		while(result) {
			String sentence = in.nextLine();
			String[] arr = sentence.split(" ");
		
		//If it starts with end, then stop the programme
		if(arr[0].equals("end")) {
			System.out.println("End of programme");
			System.exit(0);
			result = false;
		}

		//Print the sentence and the words
		System.out.println("Line (or end)): " + sentence);
		for(int i = 0; i < arr.length; i++) {
			System.out.println("Woord " + (i + 1) + ": " + arr[i]);
		}
		
		}
		in.close();
	}

}
