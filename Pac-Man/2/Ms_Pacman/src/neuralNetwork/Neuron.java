package neuralNetwork;

import java.util.ArrayList;
import java.util.Random;

public class Neuron {
	public int m_NumberOfInputs;
	public ArrayList<Double> m_WeightList = new ArrayList<Double>();
	
	Random rnd = new Random();
	
	Para parameter;
	
	public Neuron(int NumberOfInputs)
	{
		parameter = new Para();
		m_NumberOfInputs = NumberOfInputs+1;
				
		for(int i=0; i<m_NumberOfInputs; ++i)
		{
			double temp = parameter.Rnd(-1, 1);
			//double temp2 = parameter.Rnd(0, 0.5);
			m_WeightList.add(temp);
			System.out.println(m_WeightList.get(i));
		}
	}
	
	public void UpdateWeights(int NumberOfInputs)
	{
		m_NumberOfInputs = NumberOfInputs;
		for(int i=0; i<m_NumberOfInputs+1; ++i)
		{
			m_WeightList.add(rnd.nextDouble());
		}
	}

}
