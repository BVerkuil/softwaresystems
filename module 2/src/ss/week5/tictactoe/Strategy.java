package ss.week5.tictactoe;

public interface Strategy {
	
	//Returns name of strategy
	public String getName();
	
	//Returns next legal move
	public int determineMove(Board b, Mark m);
	

}
