
import java.util.ArrayList;

public class Candidate {

	private String name;
	private ArrayList<Vote> votes;
	private double numOfVotes;
	
	//arraylist of doubles (percentage of votes per candidate)
	
	public Candidate(String name) {
		this.setName(name);
		votes = new ArrayList<Vote>();
		numOfVotes = 0;
	}
	
	public void sumVotes() {
		numOfVotes = 0;
		for(Vote vote: votes) {
			numOfVotes += vote.getWeight();
		}
	}

	public void addVote(Vote vote) {
		votes.add(vote);
	}

	public String getName() {
		return name;
	}
	
	public ArrayList<Vote> getVotes() {
		return votes;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public double getVoteScore() {
		sumVotes();
		return numOfVotes;
	}
	
	public void addFrac(double weight) {
		numOfVotes += weight;
	}

}
