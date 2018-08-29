/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ANN;
import java.util.ArrayList;
import pacman.game.Constants;
import pacman.game.Game;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
/**
 *
 * @author Emil
 */
public class DataContextAnn {
    
        MOVE current_move;
	int ghostClosestToPacman;
        GHOST ghostNode;
        Game currentState;
	int[] pills, pillsArray;
	int[] pp;
	
        
        int Blinky, Pinky, Inky, Sue, Pacman;
        
        public void proccessGameState(Game state){
		
		currentState = state;
		Pacman = state.getPacmanCurrentNodeIndex();	
		Blinky = state.getGhostCurrentNodeIndex(GHOST.BLINKY);
		Pinky = state.getGhostCurrentNodeIndex(GHOST.PINKY);
		Inky = state.getGhostCurrentNodeIndex(GHOST.INKY);
		Sue = state.getGhostCurrentNodeIndex(GHOST.SUE);
		ClosestGhost(state);
		PowerPills(state);
                Pills(state);
		
		
	}
        
        public GHOST ClosestGhost(Game state)
	{
		ghostClosestToPacman =  state.getShortestPathDistance(Pacman, Blinky);
		ghostNode = GHOST.BLINKY;
                
                if(ghostClosestToPacman <  state.getShortestPathDistance(Pacman, Blinky))
		{
			ghostClosestToPacman = state.getShortestPathDistance(Pacman, Blinky);
			ghostNode = GHOST.BLINKY;
		}
		
		if(ghostClosestToPacman <  state.getShortestPathDistance(Pacman, Inky))
		{
			ghostClosestToPacman = state.getShortestPathDistance(Pacman, Inky);
			ghostNode = GHOST.INKY;
		}
		
		if(ghostClosestToPacman <  state.getShortestPathDistance(Pacman, Pinky))
		{
			ghostClosestToPacman =  state.getShortestPathDistance(Pacman, Pinky);
			ghostNode = GHOST.PINKY;

		}
		
		if(ghostClosestToPacman <  state.getShortestPathDistance(Pacman, Sue))
		{
			ghostClosestToPacman =  state.getShortestPathDistance(Pacman, Sue);
			ghostNode = GHOST.SUE;

		}
		
		
		return ghostNode;
	}
                
        public int[] Pills(Game state)
	{
            pills=state.getPillIndices();
		
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
		int cPP = 0;
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
        
        public float Input1(Game state)
        {
            float tempPathDistance = state.getShortestPathDistance(state.getPacmanCurrentNodeIndex(), state.getGhostCurrentNodeIndex(ghostNode));
            
            tempPathDistance *= -1;
            tempPathDistance += 40;
            
            return tempPathDistance;
            
        }
        
        public float Input2(Game state)
        {
            float tempPathDistance = state.getShortestPathDistance(state.getPacmanCurrentNodeIndex(),
                    state.getClosestNodeIndexFromNodeIndex(state.getPacmanCurrentNodeIndex(),
                                        pp,Constants.DM.PATH));
               return tempPathDistance;
        }
        
         public float Input3(Game state)
        {            
           float tempPathDistance = state.getShortestPathDistance(state.getPacmanCurrentNodeIndex(),
                    state.getClosestNodeIndexFromNodeIndex(state.getPacmanCurrentNodeIndex(),
                                        pills,Constants.DM.PATH));
       
            return tempPathDistance;
            
        }
         
        
                
    
}
