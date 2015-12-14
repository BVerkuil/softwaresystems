package ss.week5.tictactoe;

import java.util.HashSet;
import java.util.Set;

public class NaiveStrategy implements Strategy{



	public String getName() {
		return "Naive";
	}

	public int determineMove(Board b, Mark m) {
		int random = -1;		
		Set<Integer> empty = new HashSet<Integer>();
		for (int i = 0; i < Board.DIM * Board.DIM; i++) {
			if (b.isEmptyField(i)) {
				empty.add(i);
			}
		}
		while(!empty.contains(random)) {
			random = (int)(Math.random() * 9);
		}
		return random;
	}
}
