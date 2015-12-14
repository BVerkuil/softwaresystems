package ss.week5.tictactoe;


public class ComputerPlayer extends Player {

	private Strategy strategy;
	private Mark mark;
	
	public ComputerPlayer(Mark mark,Strategy strategy) {
		super(strategy.getName() + "-" + mark, mark);
		this.strategy = strategy;
		this.mark = mark;
	}
	
	public ComputerPlayer(Mark mark) {
		super("Naive-" + mark, mark);
		this.strategy = new NaiveStrategy();
		this.mark = mark;
	}


	public int determineMove(Board board) {
		return strategy.determineMove(board, mark);
	}
	
	public Strategy getStrategy() {
		return strategy;
	}
	
	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
	

}
