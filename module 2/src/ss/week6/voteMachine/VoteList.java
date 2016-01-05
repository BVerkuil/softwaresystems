package ss.week6.voteMachine;

import java.util.Observable;
import java.util.HashMap;

public class VoteList extends Observable{
	private HashMap<String, Integer> voteList;
	
	public VoteList() {
		voteList = new HashMap<String, Integer>();
	}
	
	public void addVote(String party) {
		if (voteList.containsKey(party)) {
			voteList.replace(party, voteList.get(party) + 1);
		} else {
			voteList.put(party, 1);
		}
		setChanged();
		notifyObservers("vote");
	}
	public HashMap<String, Integer> getVotes() {
		return voteList;
	}

}
