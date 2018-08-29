package neuralNetwork;

import java.util.Random;

public class Para {
	int bias 					= -1;
	int numberOfInputs 			= 3;
	int numberOfHiddenLayers 	= 1;
	int neuronsPerHiddenLayer  	= 5;
	int numberOfOutputs 		= 5;

	double crossoverRate;
	double mutationRate;
	double maxPerturbation;
	
	double m_StartVal;
	double m_EndVal;
	
	public Para()
	{
		
	}
	
	public double Rnd(double startVal, double endVal)
	{
		m_StartVal = startVal;
		m_EndVal = endVal;		
		double random = new Random().nextDouble();
		double result = m_StartVal + (random * (m_EndVal - m_StartVal));		
		return result;		
	}
}
