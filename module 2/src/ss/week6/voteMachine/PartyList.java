package ss.week6.voteMachine;

import java.util.Observable;
import java.util.ArrayList;

public class PartyList extends Observable{
	private ArrayList<String> partyList;
	
	public PartyList() {
		partyList = new ArrayList<String>();
	}
	
	public void addParty(String party) {
		partyList.add(party);
		setChanged();
		notifyObservers("party");
	}
	
	public ArrayList<String> getParties() {
		return partyList;
	}
	
	public boolean hasParty(String party) {
		return partyList.contains(party);
	}
}
