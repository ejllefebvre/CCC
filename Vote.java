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
 }

