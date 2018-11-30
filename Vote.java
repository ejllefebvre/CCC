import java.util.ArrayList;

public class Vote extends ArrayList<String>{

	public static double weight;
	
	public Vote(double weightInput) {
		weight = weightInput;
		round(weight);
	}
	
	public void round(double n) {
		n *= 100;
		n = Math.round(n);
		n /= 100;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double inputWeight) {
		weight = inputWeight;
	}
	
	public void nextValidVote(ArrayList<Candidate> candidates) {
		for(int i=0; i<this.size(); i++) {
			if(isValid(candidates, this.get(i))) {
				break;
			} else {
				this.remove(i);
				break;
			}
		}
	}
	
	public boolean isValid(ArrayList<Candidate> candidates, String string) {
		boolean isValid = false;
		
		for(Candidate candidate: candidates) {
			if(candidate.getName().equalsIgnoreCase(string)) {
				isValid = true;
				break;
			}
		}
		
		return isValid;
	}
 }

