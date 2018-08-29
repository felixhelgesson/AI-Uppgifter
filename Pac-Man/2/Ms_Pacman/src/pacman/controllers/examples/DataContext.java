package pacman.controllers.examples;

import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;

import java.util.ArrayList;

import pacman.game.Game;

public class DataContext {
	
	public float avDistanceToGhost;
	public NearestPillPacMan nearestPill;
	public MOVE move;
	Game game;
	MyPacmanController controller;
	
	public RETURNVALUE returnValue;
	int MIN_DISTANCE=20;
	
	public DataContext(MyPacmanController controller)
	{
		this.controller = controller;
	}
	
	public MOVE MoveToNearestPill(Game game)
	{		
		returnValue = RETURNVALUE.RUNNING;
		if(IsGhostToClose(game))
		{
			returnValue = RETURNVALUE.FAILIURE;
			return controller.move;
		}
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
		returnValue = RETURNVALUE.SUCCESS;
		return game.getNextMoveTowardsTarget(current,game.getClosestNodeIndexFromNodeIndex(current,targetsArray,DM.PATH),DM.PATH);
		//System.out.println(game.getNextMoveTowardsTarget(current,game.getClosestNodeIndexFromNodeIndex(current,targetsArray,DM.PATH),DM.PATH));
	}
	
	public boolean IsGhostToClose(Game game)
	{
		int current=game.getPacmanCurrentNodeIndex();
		for(GHOST ghost : GHOST.values())
		{		
			if(game.getGhostEdibleTime(ghost)==0 && game.getGhostLairTime(ghost)==0)
			{
				if(game.getShortestPathDistance(current,game.getGhostCurrentNodeIndex(ghost))<MIN_DISTANCE)
				{
					return true;
				}
				else 
				{
					return false;
				}
			}
		}
		return false;
	
	}
		
	public MOVE MoveFromNearestHostileGhost(Game game)
	{
		returnValue = RETURNVALUE.RUNNING;
		//int MIN_DISTANCE=20;
		int current=game.getPacmanCurrentNodeIndex();
		for(GHOST ghost : GHOST.values())
			if(game.getGhostEdibleTime(ghost)==0 && game.getGhostLairTime(ghost)==0)
			{
				if(game.getShortestPathDistance(current,game.getGhostCurrentNodeIndex(ghost))<MIN_DISTANCE)
				{
					returnValue = RETURNVALUE.SUCCESS;
					return game.getNextMoveAwayFromTarget(game.getPacmanCurrentNodeIndex(),game.getGhostCurrentNodeIndex(ghost),DM.PATH);
				}				
				else
				{
					returnValue = RETURNVALUE.FAILIURE;
					return controller.move;
				}
			}
		returnValue = RETURNVALUE.FAILIURE;
		return controller.move;
	}
	
	public MOVE MoveToNearestEdibleGhost(Game game)
	{
		returnValue = RETURNVALUE.RUNNING;
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
			returnValue = RETURNVALUE.SUCCESS;
			return game.getNextMoveTowardsTarget(game.getPacmanCurrentNodeIndex(),game.getGhostCurrentNodeIndex(minGhost),DM.PATH);		
		}
		else
		{
			returnValue = RETURNVALUE.FAILIURE;						
			return controller.move;		
		}
	}
	
	public MOVE GetNearestPowerPill(Game game)
	{
		//more stuffs here
		returnValue = RETURNVALUE.RUNNING;
		int current=game.getPacmanCurrentNodeIndex();
		int[] powerPills=game.getPowerPillIndices();
		
		ArrayList<Integer> targets=new ArrayList<Integer>();
		
		for(int i=0;i<powerPills.length;i++)			//check with power pills are available
			if(game.isPowerPillStillAvailable(i))
				targets.add(powerPills[i]);	
		
		if(targets.size()<= 0)
		{
			returnValue = RETURNVALUE.FAILIURE;
			return controller.move;
		}
		
		returnValue = RETURNVALUE.SUCCESS;
		int[] targetsArray=new int[targets.size()];		//convert from ArrayList to array
		
		for(int i=0;i<targetsArray.length;i++)
			targetsArray[i]=targets.get(i);
		
		//return the next direction once the closest target has been identified
		return MoveToNearestEdibleGhost(game);
		//return game.getNextMoveTowardsTarget(current,game.getClosestNodeIndexFromNodeIndex(current,targetsArray,DM.PATH),DM.PATH);				
	}
	
	
	
	
	

}
