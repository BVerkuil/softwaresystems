package ss.week6;

import java.util.Scanner;

public class Words {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String sentence = in.nextLine();
		String[] arr = sentence.split(" ");
		for(String s : arr) {
			System.out.println(s);
		}
	}

}
