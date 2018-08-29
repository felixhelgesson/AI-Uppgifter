package pacman.states;

import java.util.ArrayList;

import pacman.controllers.examples.DataContext;
import pacman.controllers.examples.MyPacmanController;
import pacman.controllers.examples.RETURNVALUE;
import pacman.game.Game;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;

public class ChaseState extends BTState {

	DataContext data;
	MOVE returnMove;
	public ChaseState(MyPacmanController controller) 
	{
		super(controller);
		this.controller = controller;
		data = new DataContext(controller);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public RETURNVALUE GetReturnvalue()
	{
		if(returnMove != null ||returnMove != MOVE.NEUTRAL)
		{
			return RETURNVALUE.RUNNING;
		}
		else 
		{	
		return RETURNVALUE.SUCCESS;
		}
	}
	
	@Override
	public MOVE GetMove(Game game)
	{
		for(GHOST ghost : GHOST.values())
			if(game.getGhostEdibleTime(ghost)>0)
			{
				returnValue = RETURNVALUE.SUCCESS;
			}
		
		//System.out.println("simon says Chase" + returnValue);
		int current=game.getPacmanCurrentNodeIndex();
		int[] powerPills=game.getPowerPillIndices();
		
		ArrayList<Integer> targets=new ArrayList<Integer>();
		
		for(int i=0;i<powerPills.length;i++)			//check with power pills are available
			if(game.isPowerPillStillAvailable(i))
				targets.add(powerPills[i]);	
		
		if(targets.size()<= 0)
		{
			returnValue = RETURNVALUE.SUCCESS;
			return controller.move;
		}
		
		int[] targetsArray=new int[targets.size()];		//convert from ArrayList to array
		
		for(int i=0;i<targetsArray.length;i++)
			targetsArray[i]=targets.get(i);
		
		if(data.IsGhostToClose(game)==false &&data.IsPillClose(game)== true)
		{
			returnValue = RETURNVALUE.RUNNING;
			System.out.println("simon says Chase hi my name is" + returnValue);
			return game.getNextMoveTowardsTarget(current,game.getClosestNodeIndexFromNodeIndex(current,targetsArray,DM.PATH),DM.PATH);
		}
		else if(data.IsGhostToClose(game)==true)
			returnValue = RETURNVALUE.FAILIURE;
		
		//return the next direction once the closest target has been identified
		//return MoveToNearestEdibleGhost(game);
		//return game.getNextMoveTowardsTarget(current,game.getClosestNodeIndexFromNodeIndex(current,targetsArray,DM.PATH),DM.PATH);
		//returnValue = RETURNVALUE.RUNNING;
		//returnMove = data.GetNearestPowerPill(game);	
		//returnValue = data.returnValue;
		//if(returnValue == RETURNVALUE.RUNNING)
		//	System.out.println("yes");
			
		System.out.println("simon says Chase" + returnValue);
		return returnMove;
	}

}
