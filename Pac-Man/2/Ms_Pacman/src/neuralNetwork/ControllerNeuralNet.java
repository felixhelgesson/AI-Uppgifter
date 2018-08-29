package neuralNetwork;

import java.lang.reflect.Parameter;
import java.util.ArrayList;

import pacman.controllers.Controller;
import pacman.game.Constants.MOVE;
import pacman.game.Game;

public class ControllerNeuralNet extends Controller<MOVE> {

	int m_Ticks;
	int m_Generation;
	int m_CountCheck;
	
	double i1;
	double i2;
	double i3;
	double i4;
	
	ArrayList<Candidate> m_Population = new ArrayList<Candidate>();
	ArrayList<Double> m_avgFitness = new ArrayList<Double>();
	ArrayList<Double> m_bestFitness = new ArrayList<Double>();
	ArrayList<Double> m_inputs = new ArrayList<Double>();
	ArrayList<Double> m_outputs= new ArrayList<Double>();
	
	
	GenericAlgorithm 	gAlgorithm;
	NeuralNet 			nn;
	Parameter 			parameter;
	Perception 			perception;
	DataContextNN 		dataContex; 
	
	MOVE move;
	
	public ControllerNeuralNet()
	{
		nn = new NeuralNet();
		perception = new Perception(this);
		dataContex = new DataContextNN(this);
		
		m_inputs.add(0.0);
		m_inputs.add(0.0);
		m_inputs.add(1.0);
	}
	@Override
	public MOVE getMove(Game game, long timeDue) {
		// TODO Auto-generated method stub
		//update(game);
		m_inputs.clear();
		m_inputs = perception.GetInputData(game);
		System.out.println("inputs:" +m_inputs);

		m_outputs = nn.Update2(m_inputs);
		System.out.println("outputs:"+m_outputs);
		
		if(m_outputs.get(0)>m_outputs.get(1) 
				&& m_outputs.get(0)>m_outputs.get(2))
		{		
			System.out.println("1");
			move = dataContex.MoveFromNearestHostileGhost(game);	
			m_inputs.clear();
			m_inputs = perception.GetInputData(game);			
		}
		
		if(m_outputs.get(1)>m_outputs.get(0) 
				&& m_outputs.get(1)>m_outputs.get(2))
		{
			System.out.println("2");
			move = dataContex.MoveToNearestPill(game);
			m_inputs.clear();
			m_inputs = perception.GetInputData(game);		
		}
		
		if(m_outputs.get(2)>m_outputs.get(0) 
				&& m_outputs.get(2)>m_outputs.get(1))
		{			
			System.out.println("3");
			move = dataContex.GetNearestPowerPill(game);
			m_inputs.clear();
			m_inputs = perception.GetInputData(game);
		}
		m_outputs.clear();
		
		return move;
	}
	
	boolean update(Game game)
	{
		//----------------To-Do------------------
		//		1.Vad fan ska göras med output
		//		2.Threshholds sigmoids
		//		3.GA för att änra weights
		//---------------------------------------

		m_inputs = perception.GetInputData(game);
		//System.out.println(m_inputs);
		m_outputs = nn.Update2(m_inputs);
		System.out.println(m_outputs);
		
		if(m_outputs.get(0)>m_outputs.get(1))
		{
			move = dataContex.MoveToNearestPill(game);
		}
		if(m_outputs.get(1)>m_outputs.get(0))
		{
			move = dataContex.MoveFromNearestHostileGhost(game);
		}

		//System.out.println(mode);
		m_outputs.clear();
		
		for(int i = 0; i<m_outputs.size(); ++i)
		{
			m_inputs.add(m_outputs.get(i));
			//System.out.println(m_inputs);
		}

		
		//m_avgFitness.add(gAlgorithm.AvgFitness());
		//m_bestFitness.add(gAlgorithm.BestFitness());
		
		return true;
	}

}
