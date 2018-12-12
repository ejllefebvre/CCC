import java.util.ArrayList;

public class Round {
	
	int numCandidates;
	int majority;
	Boolean winner;
	Candidate winningCandidate;
	double threshold;
	int numWinning;
	int seatsToFill;
	
	ArrayList<Vote> master;
	ArrayList<Vote> masterCopy;
	ArrayList<Vote> nextRound;
	
	ArrayList<Candidate> byCandidate;
	ArrayList<Candidate> nextRoundCandidates;
	
	public Round(ArrayList<Candidate> candidates, ArrayList<Vote> input, int seats) {
		master = input;
		masterCopy = createCopy(master);
		majority = master.size()/2;
		numCandidates = candidates.size();
		seatsToFill = seats;
		threshold = master.size()/(seats+1) + 1;
		numWinning = 0;
		
		byCandidate = candidates;
		nextRound = new ArrayList<Vote>();
		nextRoundCandidates = new ArrayList<Candidate>();
		
		sortMaster();
		printResults();
		if(winner) {
			System.out.println();
			System.out.println(winningCandidate.getName() + " has won");
		} else {
			redistribute();
			System.out.println(nextRound);
			System.out.println();
			System.out.println();
			new Round(this.getNextRoundCandidates(), this.getNextRoundList(), this.seatsToFill);
		}
	}
	
	public ArrayList<Vote> createCopy(ArrayList<Vote> masterInput) {
		ArrayList<Vote> copy = new ArrayList<Vote>();
		for(Vote vote: masterInput) {
			copy.add((Vote) vote.clone());
		}
		
		return copy;
	}
	
	public int getMaxIndex() {
		int maxIndex = 0;
		for(int i = 0; i<byCandidate.size(); i++) {
			if(byCandidate.get(i).getVoteScore()>maxIndex) {
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	
	public void redistribute() {
		int maxIndex = getMaxIndex();
		double maxVotes
		if(byCandidate.get(maxIndex).getVoteScore()>=threshold) {
			double weight = 
		}
	}

	public boolean checkForWinner() {
		winner = false;
		
		for(Candidate candidate: byCandidate) {
			if(candidate.getVoteScore() > majority) {
				winner = true;
				winningCandidate = candidate;
			}
		}
		return winner;
	}
	
	public void sortMaster() {
		for(Vote vote: masterCopy) {
			sortVote(vote);
		}
	}
	
	public void sortVote(Vote vote) {
		String validVote = vote.get(0);
		
		for(Candidate candidate: byCandidate) {
			if(validVote.equalsIgnoreCase(candidate.getName())) {
				candidate.addVote(vote);
			}
		}
	}
	
	public void printResults() {
		for(Candidate candidate: byCandidate) {
			System.out.println(candidate.getName() + ": " + candidate.getVoteScore());
			for(Vote vote: candidate.getVotes()) {
				System.out.println(vote);
			}
			
			checkForWinner();
		}
	}
	
	public void createNextRoundList() {
		for(Candidate candidate: byCandidate) {
			for(Vote vote: candidate.getVotes()) {
				vote.nextValidVote(nextRoundCandidates);
				nextRound.add(vote);
			}
		}
	}
	
	public int findMinimum(ArrayList<Candidate> candidates) {
		double minimumVotes = candidates.get(0).getVoteScore();
		int minimumIndex = 0;
		
		for(int i=0; i<candidates.size(); i++) {
			if(candidates.get(i).getVoteScore() < minimumVotes && candidates.get(i).getVoteScore() > 0) {
				minimumVotes = candidates.get(i).getVoteScore();
				minimumIndex = i;
			} 
		}
		
		createNextRoundCandidates(candidates, minimumIndex);
		
		return minimumIndex;
	}
	
	public void createNextRoundCandidates(ArrayList<Candidate> candidates, int minimumIndex) {
		for(int i=0; i<candidates.size(); i++) {
			if(i != minimumIndex && !(candidates.get(i).getVoteScore() == 0)) {
				nextRoundCandidates.add(candidates.get(i));
			}
			
		}
	}

	public ArrayList<Vote> getNextRoundList() {
		return nextRound;
	}
	
	public ArrayList<Candidate> getNextRoundCandidates() {
		return nextRoundCandidates;
	}
}
