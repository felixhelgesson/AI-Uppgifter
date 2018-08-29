package neuralNetwork;

import java.util.ArrayList;
import java.util.Random;

public class GenericAlgorithm {
	
	ArrayList<Candidate> m_Population;
	int m_PopSize;
	int m_ChromosomeLenght;
	double m_TotalFitness;
	double m_AverageFitness;
	double m_WorstFitness;
	double m_FittestCandidate;
	double m_MutationRate;
	double m_CrossRate;
	
	Random rnd = new Random();
	Para parameter;
	
	void Cross(ArrayList<Double> mum,ArrayList<Double> dad,ArrayList<Double> baby1,ArrayList<Double> baby2)
	{
		
	}
	
	void Mutate(ArrayList<Double> chromosome)
	{
		
	}
	
	void GetBest(int best, int numberOfCopies, ArrayList<Candidate> pop)
	{
		
	}
	
	void Calculation()
	{
		
	}
	
	void Reset()
	{
		
	}
	
	public GenericAlgorithm(int population, double mutationRate, double crossRate, int numWeights)
	{
		m_PopSize = population;
		m_MutationRate = mutationRate;
		m_CrossRate = crossRate;
		
		parameter = new Para();
		
		for(int i =0; i<m_PopSize; ++i)
		{
			m_Population.add(new Candidate());
			for(int j =0; j<m_ChromosomeLenght; ++j)
			{
				m_Population.get(i).weightList.add(parameter.Rnd(0, 1));
			}
		}
	}
	
	public ArrayList<Candidate> OneGeneration(ArrayList<Candidate> old_pop)
	{
		return null;
	}
	
	public ArrayList<Candidate> GetChromosones()
	{
		return m_Population;	
	}
	
	double AvgFitness()
	{
		return m_TotalFitness / m_PopSize;
	}
	
	double BestFitness()
	{
		return m_FittestCandidate;
	}
	
	
}
