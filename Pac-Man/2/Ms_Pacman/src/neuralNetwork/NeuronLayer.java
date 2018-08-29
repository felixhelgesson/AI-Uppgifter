package neuralNetwork;

import java.util.ArrayList;

public class NeuronLayer {
	public int m_NumberOfNeurons;
	public int m_NumberOfInputsPerNeuron;
	public ArrayList<Neuron> m_NeuronsList = new ArrayList<Neuron>();
	
	public NeuronLayer(int NumberOfNeurons, int NumberOfInputsPerNeuron)
	{
		m_NumberOfNeurons = NumberOfNeurons;
		m_NumberOfInputsPerNeuron = NumberOfInputsPerNeuron;
		for(int i=0; i<m_NumberOfNeurons; ++i)
		{
			m_NeuronsList.add(new Neuron(m_NumberOfInputsPerNeuron));
		}
	}

}
