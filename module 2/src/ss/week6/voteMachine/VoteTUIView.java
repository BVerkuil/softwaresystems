package ss.week6.voteMachine;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class VoteTUIView implements Observer, VoteView {
	
	private VoteMachine controller;

	private PrintStream out = System.out;
	
	public VoteTUIView(VoteMachine c){
		controller = c;
	}

	public void start() {
		Scanner in = new Scanner(System.in);
		boolean finished = false;

		while (!finished) {
			out.print("ENTER COMMAND: ");
			if (in.hasNextLine()) {
				String input = in.nextLine();
				Scanner cs = new Scanner(input);
				if (cs.hasNext()) {
					String command = cs.next();
					switch (command) {
					case "VOTES":
						showVotes(getVotes());
						break;
					case "PARTIES":
						showParties(getParties());
						break;
					case "EXIT":
						finished = true;
						break;
					case "HELP":
						out.println("Available commands: VOTES, PARTIES, VOTE [PARTY], ADD PARTY [party], EXIT. HELP");
					default:
						if (cs.hasNext()) {
							if (command.equals("VOTE")) {
								controller.addVote(cs.next());
							} else {
								if (command.equals("ADD") && cs.next().equals("PARTY") && cs.hasNext()) {
									controller.addParty(cs.next());
								}
							}
						}
					}
				}cs.close();
			}
		}in.close();
	}

	public void showVotes(Map<String, Integer> map) {
		out.println("--VOTES--");
		for (Entry<String, Integer> e : map.entrySet()) {
			out.println(e.getKey() + ": " + e.getValue());
		}
	}

	public void showParties(List<String> list) {
		out.println("--PARTIES--");
		for (String s : list) {
			out.println(" + " + s);
		}
	}
	
	public void showError(String s){
		out.println("ERROR: " + s);
	}
	
	private List<String> getParties(){
		return controller.getParties();
	}
	private Map<String, Integer> getVotes(){
		return controller.getVotes();
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg.equals("vote")){
			out.println("> vote added");
		} else if (arg.equals("party")){
			out.println("> party added");
		}		
	}
}