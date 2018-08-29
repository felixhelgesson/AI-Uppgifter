package neuralNetwork;

import java.util.ArrayList;

public class Candidate {
	
	ArrayList<Double> weightList = new ArrayList<Double>();
	double fitness;
	
	public Candidate()
	{
		fitness = 0;
	}
	
	public Candidate(ArrayList<Double> w, double f)
	{
		weightList = w;
		fitness = f;
	}

}
