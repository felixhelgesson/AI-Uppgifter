package neuralNetwork;

import java.util.ArrayList;

import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.controllers.examples.RETURNVALUE;
import pacman.game.Game;

public class DataContextNN {
	
	double m_ClosestPill;
	double m_ClosestPP;
	double m_ClosestGhost;
	int m_changeDoubles = 1000;
	int MIN_DISTANCE=20;
	
	ControllerNeuralNet m_controller;
	
	public DataContextNN(ControllerNeuralNet controller)
	{
		m_controller = controller;
	}
	
	public MOVE MoveToNearestEdibleGhost(Game game)
	{
		int current=game.getPacmanCurrentNodeIndex();
		int minDistance=Integer.MAX_VALUE;
		GHOST minGhost=null;		
		
		for(GHOST ghost : GHOST.values())
			if(game.getGhostEdibleTime(ghost)>0)
			{
				int distance=game.getShortestPathDistance(current,game.getGhostCurrentNodeIndex(ghost));
				
				if(distance<minDistance)
				{
					minDistance=distance;
					minGhost=ghost;
				}
			}
		
		
		if(minGhost!=null)
		{//we found an edible ghost
			return game.getNextMoveTowardsTarget(game.getPacmanCurrentNodeIndex(),game.getGhostCurrentNodeIndex(minGhost),DM.PATH);		
		}
		else
		{				
			return m_controller.move;		
		}
	}
	
	public MOVE GetNearestPowerPill(Game game)
	{
		//more stuffs here
		int current=game.getPacmanCurrentNodeIndex();
		int[] powerPills=game.getPowerPillIndices();
		
		ArrayList<Integer> targets=new ArrayList<Integer>();
		
		for(int i=0;i<powerPills.length;i++)			//check with power pills are available
			if(game.isPowerPillStillAvailable(i))
				targets.add(powerPills[i]);	
		
		if(targets.size()<= 0)
		{
			
			return m_controller.move;
		}
		
		int[] targetsArray=new int[targets.size()];		//convert from ArrayList to array
		
		for(int i=0;i<targetsArray.length;i++)
			targetsArray[i]=targets.get(i);
		
		//return the next direction once the closest target has been identified
		return game.getNextMoveTowardsTarget(current,game.getClosestNodeIndexFromNodeIndex(current,targetsArray,DM.PATH),DM.PATH);				
		//return MoveToNearestEdibleGhost(game);
	}
	
	public MOVE MoveFromNearestHostileGhost(Game game)
	{
		
		int current=game.getPacmanCurrentNodeIndex();
		for(GHOST ghost : GHOST.values())
			if(game.getGhostEdibleTime(ghost)==0 && game.getGhostLairTime(ghost)==0)
			{
				if(game.getShortestPathDistance(current,game.getGhostCurrentNodeIndex(ghost))<MIN_DISTANCE)
				{
					return game.getNextMoveAwayFromTarget(game.getPacmanCurrentNodeIndex(),game.getGhostCurrentNodeIndex(ghost),DM.PATH);
				}				
				else
				{
					return m_controller.move;
				}
			}

		return m_controller.move;
	}
	
	public MOVE MoveToNearestPill(Game game)
	{		
		
		int current=game.getPacmanCurrentNodeIndex();
		int[] pills=game.getPillIndices();
		int[] powerPills=game.getPowerPillIndices();		
		
		ArrayList<Integer> targets=new ArrayList<Integer>();
		
		for(int i=0;i<pills.length;i++)					//check which pills are available			
			if(game.isPillStillAvailable(i))
				targets.add(pills[i]);
		
		for(int i=0;i<powerPills.length;i++)			//check with power pills are available
			if(game.isPowerPillStillAvailable(i))
				targets.add(powerPills[i]);				
		
		int[] targetsArray=new int[targets.size()];		//convert from ArrayList to array
		
		for(int i=0;i<targetsArray.length;i++)
			targetsArray[i]=targets.get(i);
		
		//return the next direction once the closest target has been identified
	
		return game.getNextMoveTowardsTarget(current,game.getClosestNodeIndexFromNodeIndex(current,targetsArray,DM.PATH),DM.PATH);
	}
	
	//-----------------perceptionList
	public ArrayList<Double> Perception(Game game)
	{
		ArrayList<Double> perception = new ArrayList<Double>(); 
		int current=game.getPacmanCurrentNodeIndex();
		
		
		for(GHOST ghost : GHOST.values())
		{		
			if(game.getGhostEdibleTime(ghost)==0 && game.getGhostLairTime(ghost)==0)
			{
				m_ClosestGhost = game.getDistance(game.getGhostCurrentNodeIndex(ghost),current,DM.PATH);					
			}
		}
		
		perception.clear();
		
		m_ClosestGhost= m_ClosestGhost/m_changeDoubles;
		perception.add(m_ClosestGhost);
		perception.add(GetPillInput(game));
		perception.add(GetPowerPillInput(game));
		return perception;

	}
	//-----------GetPillInput---------------------------
	public double GetPillInput(Game game)
	{
		int current=game.getPacmanCurrentNodeIndex();
		int[] pills=game.getPillIndices();
		int[] powerPills=game.getPowerPillIndices();		
		
		ArrayList<Integer> targets=new ArrayList<Integer>();
		
		for(int i=0;i<pills.length;i++)					//check which pills are available			
			if(game.isPillStillAvailable(i))
				targets.add(pills[i]);
		
		for(int i=0;i<powerPills.length;i++)			//check with power pills are available
			if(game.isPowerPillStillAvailable(i))
				targets.add(powerPills[i]);				
		
		int[] targetsArray=new int[targets.size()];		//convert from ArrayList to array
		
		for(int i=0;i<targetsArray.length;i++)
			targetsArray[i]=targets.get(i);
		
		double minDistance = 100000;
		m_ClosestPill = -1;
		for(int i=0;i<targetsArray.length;i++)
		{
			double distance = 0;
			//DM kan behöva ändras
			distance=game.getDistance(targetsArray[i],current,DM.PATH);
			
			if(distance<minDistance)
			{
				minDistance = distance;
				m_ClosestPill = targetsArray[i];
			}
		
		}
		///m_ClosestPill = game.getEuclideanDistance(current, targetsArray)
		m_ClosestPill = m_ClosestPill/m_changeDoubles;
		return m_ClosestPill;
	}
	
	//-----------GetPowerPillInput---------------------------
	public double GetPowerPillInput(Game game)
	{
		int current=game.getPacmanCurrentNodeIndex();
		int[] powerPills=game.getPowerPillIndices();
		
		ArrayList<Integer> targets=new ArrayList<Integer>();
		
		for(int i=0;i<powerPills.length;i++)			//check with power pills are available
			if(game.isPowerPillStillAvailable(i))
				targets.add(powerPills[i]);	
		
		if(targets.size()<= 0)
		{
			//m_ClosestPP = 0;
			System.out.println("zeroPillsLeft");
			return 1.5;
		}
		
		int[] targetsArray=new int[targets.size()];		//convert from ArrayList to array
		
		
		for(int i=0;i<targetsArray.length;i++)
			targetsArray[i]=targets.get(i);
		
		
		double minDistance = 10000000;
		m_ClosestPP = -1;
		for(int i=0;i<targetsArray.length;i++)
		{
			double distance = 0;
			distance=game.getDistance(targetsArray[i],current,DM.PATH);
			
			if(distance<minDistance)
			{
				minDistance = distance;
				m_ClosestPP = targetsArray[i];
			}		
		}		
		m_ClosestPP= m_ClosestPP/m_changeDoubles;
		return  m_ClosestPP;
	}
}
