package ss.week5.tictactoe;

import java.util.HashSet;
import java.util.Set;

public class SmartStrategy implements Strategy {

	public String getName() {
		return "Smart";
	}

	public int determineMove(Board b, Mark m) {
		
		boolean foundSpot = false;
		int result = -1;		
		Set<Integer> empty = new HashSet<Integer>();
		Mark opponent;
		
		//Make list of empty fields
		for (int i = 0; i < Board.DIM * Board.DIM; i++) {
			if (b.isEmptyField(i)) {
				empty.add(i);
			}
		}
		
		//Set middle if empty
		if(b.isEmptyField((Board.DIM * Board.DIM) / 2)) {
			result = (Board.DIM * Board.DIM) / 2;
			foundSpot = true;
		}
		
		//Set on position where you can win
		if (!foundSpot) {
			for (int field : empty) {
				Board copy = b.deepCopy();
				copy.setField(field, m);
				if (copy.isWinner(m)) {
					result = field;
					foundSpot = true;
				}
			}
		}
		
		//Set on position where opponent would win
		if(!foundSpot) {
			opponent  = m.other();
			for (int field : empty) {
				Board copy = b.deepCopy();
				copy.setField(field, opponent);
				if (copy.isWinner(opponent)) {
					result = field;
					foundSpot = true;
				}
			}
		}
		
		if(!foundSpot) {
			for (int i = 0; i < Board.DIM * Board.DIM; i++) {
				if (b.isEmptyField(i)) {
					empty.add(i);
				}
			}
			while(!empty.contains(result)) {
				result = (int)(Math.random() * 9);
			}
		}
		return result;
	}
}
