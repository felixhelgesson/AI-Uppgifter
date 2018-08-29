package neuralNetwork;

import java.util.ArrayList;

import pacman.game.Game;

public class Perception {
	
	double m_ClosestPill;
	double m_ClosestPP;
	
	//ArrayList<ArrayList<Double>> m_inputs = new ArrayList<ArrayList<Double>>();
	ArrayList<Double> m_Inputs = new ArrayList<Double>();
	
	Para parameters = new Para();
	DataContextNN dataContext;
	ControllerNeuralNet m_controller;
	
	public Perception(ControllerNeuralNet controller)
	{
		m_controller = controller;
		dataContext= new DataContextNN(m_controller);
	}
	
	public ArrayList<Double> GetInputData(Game game)
	{
		m_Inputs.clear();
		m_Inputs = dataContext.Perception(game);
		return m_Inputs;
	}
	
	public double GetClosestPowerPill()
	{
		return m_ClosestPP;
	}

}
