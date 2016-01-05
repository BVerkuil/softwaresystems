package ss.week6.voteMachine;

import java.util.List;
import java.util.Map;
import ss.week6.voteMachine.gui.*;

public class VoteMachine {
	
	private VoteList votelist;
	private PartyList partylist;
	VoteView v;
	
	public static void main(String args[]){
		VoteMachine vm = new VoteMachine();
		vm.start();
	}
	
	public VoteMachine(){
		votelist = new VoteList();
		partylist = new PartyList();
	}
	
	public void start(){
//		v = new VoteTUIView(this);
		v = new VoteGUIView(this);
		votelist.addObserver(v);
		partylist.addObserver(v);
		v.start();
	};
	
	public void addParty(String name){
		partylist.addParty(name);
	}
	
	public void addVote(String party){
		if (partylist.getParties().contains(party)) votelist.addVote(party);
		else v.showError("Party not found");;
	}
	
	public List<String> getParties(){
		return partylist.getParties();
	}
	
	public Map<String, Integer> getVotes(){
		return votelist.getVotes();
	}
}