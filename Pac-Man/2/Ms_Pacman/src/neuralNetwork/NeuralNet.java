package neuralNetwork;

import java.util.ArrayList;
import java.lang.*;

public class NeuralNet {
	int m_NumberOfInputs;
	int m_NumberOfOutputs;
	int m_NumberOfHiddenLayers;
	int m_NeuronsPerHiddenLayer;	
	
	ArrayList<NeuronLayer> m_NeuronLayer = new ArrayList<NeuronLayer>();
	
	Para parameter;
	
	public NeuralNet()
	{
		parameter = new Para();
		m_NumberOfInputs = 			parameter.numberOfInputs;
		m_NumberOfOutputs = 		parameter.numberOfOutputs;
		m_NumberOfHiddenLayers = 	parameter.numberOfHiddenLayers;
		m_NeuronsPerHiddenLayer = 	parameter.neuronsPerHiddenLayer;
		CreateNeuralNet();
	}
	
	void CreateNeuralNet()
	{
		if(m_NumberOfHiddenLayers > 0)
		{
			//Skapa först hidden layer
			m_NeuronLayer.add(new NeuronLayer(m_NeuronsPerHiddenLayer, m_NumberOfInputs));
			
			
			for(int i=0; i<m_NumberOfHiddenLayers-1; ++i)
			{
				//fler hiddenlayers
				m_NeuronLayer.add(new NeuronLayer(m_NeuronsPerHiddenLayer,m_NeuronsPerHiddenLayer));
			}
			//skapa output layer
			m_NeuronLayer.add(new NeuronLayer(m_NumberOfOutputs,m_NeuronsPerHiddenLayer));
		}
		else
		{
			m_NeuronLayer.add(new NeuronLayer(m_NumberOfOutputs,m_NumberOfInputs));
		}
	}
	
	ArrayList<Double> GetWeight()
	{
		ArrayList<Double> weights = new ArrayList<Double>();
		
		//loopa alla layes
		for(int i=0; i<m_NumberOfHiddenLayers + 1; ++i)
		{
			//loopa alla neurons
			for(int j=0; j<m_NeuronLayer.get(i).m_NumberOfNeurons + 1; ++j)
			{
				//för varje weight
				for (int k=0; k<m_NeuronLayer.get(i).m_NeuronsList.get(j).m_NumberOfInputs; ++k)
				{
					weights.add(m_NeuronLayer.get(i).m_NeuronsList.get(j).m_WeightList.get(k));
				}
			}
		}
		return weights;
	}
	
	int GetNumberOfWeights()
	{
		int weight = 0;
		for(int i=0; i<m_NumberOfHiddenLayers + 1; ++i)
		{
			//loopa alla neurons
			for(int j=0; j<m_NeuronLayer.get(i).m_NumberOfNeurons + 1; ++j)
			{
				//för varje weight
				for (int k=0; k<m_NeuronLayer.get(i).m_NeuronsList.get(j).m_NumberOfInputs; ++k)
				{
					weight++;
				}
			}
		}
			
		return weight;
	}
	
	//fix
	void PutWeights(ArrayList<Double> weights)
	{
		int weight = 0;
		for(int i=0; i<m_NumberOfHiddenLayers + 1; ++i)
		{
			//loopa alla neurons
			for(int j=0; j<m_NeuronLayer.get(i).m_NumberOfNeurons + 1; ++j)
			{
				//för varje weight
				for (int k=0; k<m_NeuronLayer.get(i).m_NeuronsList.get(j).m_NumberOfInputs; ++k)
				{
					//m_NeuronLayer.get(i).m_NeuronsList.get(j).m_WeightList.get(k) = weights.add(weight);
				}
			}
		}
	}
	
	//förmodligen ändras sen
	double Sigmoid(double actvation, double response)
	{
		return (1/(1+ Math.exp(-actvation/response)));
	}
	
	
	ArrayList<Double> Update2(ArrayList<Double> inputs)
	{
		//håller resultatet från varje lager
		ArrayList<Double> outputs = new ArrayList<Double>();
		
		int weight = 0;
		
		//Kolla om antelet inputs är korrekt
		if(inputs.size() != m_NumberOfInputs)
		{
			return outputs;
			//System.out.println("fail in check of amount of inputs");
		}
		
		//för varje layer
		for (int i = 0; i < m_NumberOfHiddenLayers; i++)
		{			
			if(i>0)
			{
				inputs = outputs;
			}
			
			outputs.clear();
			weight = 0;
			
			//för varje neuron
			for (int j = 0; j <m_NeuronLayer.get(i).m_NumberOfNeurons; j++) 
			{
				double netinput = 0;
				int NumInputs = m_NeuronLayer.get(i).m_NeuronsList.get(j).m_NumberOfInputs;
				
				//för varje input
				for (int k = 0; k < NumInputs -1; k++) 
				{
					netinput += m_NeuronLayer.get(i).m_NeuronsList.get(j).m_WeightList.get(k) * 
							inputs.get(weight++);
				}
				
				netinput += m_NeuronLayer.get(i).m_NeuronsList.get(j).m_WeightList.get(NumInputs -1) * parameter.bias;
				outputs.add(Sigmoid(netinput, 1));
				weight = 0;
			}
		}
		return outputs;
	}
	ArrayList<Double> Update(ArrayList<Double> inputs)
	{
		ArrayList<Double> outputs = new ArrayList<Double>();
		
		System.out.println(inputs);
		int weight = 0;
		int inputIndex =1;
		
		if(inputs.size() != m_NumberOfInputs)
		{
			return outputs;
		}
		
		for(int i = 0; i < m_NumberOfHiddenLayers; ++i)
		{
			if(i > 0)
			{
				 inputs = outputs;
			}
			
			outputs.clear();
			
			weight = 0;
			
			for(int j= 0; j< m_NeuronLayer.get(i).m_NumberOfNeurons; ++j)
			{
				double netInput = 0;
				
				int numberOfInputs = m_NeuronLayer.get(i).m_NeuronsList.get(j).m_NumberOfInputs;
			
				for(int k = 0; k<numberOfInputs - 1; ++k)
				{					
					//double inputVal = inputs.get(1);
					//System.out.println(inputs.get(0));
					//weight++;
					//netInput += m_NeuronLayer.get(i).m_NeuronsList.get(j).m_WeightList.get(k)
					//System.out.println(m_NeuronLayer.get(i).m_NeuronsList.get(j).m_WeightList.get(k));
					netInput +=  m_NeuronLayer.get(i).m_NeuronsList.get(j).m_WeightList.get(k)*
							inputs.get(++weight);
					//System.out.println(weight);
				}
				
				netInput += m_NeuronLayer.get(i).m_NeuronsList.get(j).m_WeightList.get(numberOfInputs-1)* parameter.bias;				
				outputs.add(Sigmoid(netInput,1));
				
				weight = 0;
			}
			
		}
		//System.out.println(outputs);
		return outputs;
	}
}
