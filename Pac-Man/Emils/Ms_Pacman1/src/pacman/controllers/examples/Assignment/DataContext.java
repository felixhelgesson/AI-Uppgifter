package pacman.controllers.examples.Assignment;

import java.util.ArrayList;

import pacman.game.Game;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Constants.DM;


public class DataContext {
	
	MOVE lastMove, current_move;
	int ghostClosestToPacman;
        GHOST ghostNode;
        Game currentState;
	int[] pills, pillsArray;
	int[] pp;
	int cPP, cP ;
	
	
	int Blinky, Pinky, Inky, Sue, Pacman;
	
	public void proccessGameState(Game state){
		
		currentState = state;
		
		PowerPills(state);
		
		
	}
        
        public GHOST G()
        {
            return ghostNode;
        }
        
      
	
	public boolean ClosestEdibleGhost(Game state)
	{
		for(GHOST ghost : GHOST.values())
                {
                    if(state.getGhostEdibleTime(ghost)!=0 && state.getGhostLairTime(ghost)==0)
                    {
                        if(state.getShortestPathDistance(state.getPacmanCurrentNodeIndex(),state.getGhostCurrentNodeIndex(ghost)) < 40)
                        {
                           current_move = state.getNextMoveTowardsTarget(state.getPacmanCurrentNodeIndex(), state.getGhostCurrentNodeIndex(ghost), DM.PATH);
                           ghostNode = ghost;
			   return true;
                        }
                    }
			
		        
		}
		return false;
	}
        
        public boolean CheckEscape(Game state)
        {
		for(GHOST ghost : GHOST.values())
			if(state.getGhostEdibleTime(ghost)==0 && state.getGhostLairTime(ghost)==0)
		        if(state.getShortestPathDistance(state.getPacmanCurrentNodeIndex(),state.getGhostCurrentNodeIndex(ghost)) < 40){
		        current_move = state.getNextMoveAwayFromTarget(state.getPacmanCurrentNodeIndex(), state.getGhostCurrentNodeIndex(ghost), DM.PATH);
                        ghostNode = ghost;
					return true;
					}
		return false;
	}
	
	public int GetClosestGhost(Game state)
	{
		return state.getShortestPathDistance(Pacman, state.getGhostCurrentNodeIndex(ghostNode));
	}
	
	public GHOST getGhostNode()
	{
		return ghostNode;
	}
	

	
	public int[] Pills(Game state)
	{
		int[] pills=state.getPillIndices();
		
		ArrayList<Integer> targets=new ArrayList<Integer>();
		
		for(int i=0;i<pills.length;i++)					//check which pills are available			
			if(state.isPillStillAvailable(i))
				targets.add(pills[i]);
		
        int[] targetsArray=new int[targets.size()];		//convert from ArrayList to array
		
		for(int i=0;i<targetsArray.length;i++)
			targetsArray[i]=targets.get(i);
		
		return targetsArray;

	}
        
        public int[] PowerPills(Game state)
	{
	    pp = state.getPowerPillIndices();	
	    
		ArrayList<Integer> targets=new ArrayList<Integer>();

		for(int i=0;i<pp.length;i++)
		{//check with power pills are available
			if(state.isPowerPillStillAvailable(i))
				targets.add(pp[i]);				
		}
		
        int[] targetsArray=new int[targets.size()];		//convert from ArrayList to array
		
		for(int i=0;i<targetsArray.length;i++)
			targetsArray[i]=targets.get(i);
		
		return targetsArray; 
	}
	
	public int ClosestPP(Game state)
	{
		cPP = 0;
		int[] temp = PowerPills(state);
		for(int i = 0; i < temp.length; i++)
		{		
			if(state.getShortestPathDistance(Pacman, temp[i]) > cPP)
			{
				
				cPP = temp[i];			
			}
		}
		
		return cPP;
	}
	
	public void SetCurrentMove(MOVE move)
	{
		current_move = move;
	}
	
	public MOVE GetCurrentMove()
	{
		return current_move;
	}
	
}