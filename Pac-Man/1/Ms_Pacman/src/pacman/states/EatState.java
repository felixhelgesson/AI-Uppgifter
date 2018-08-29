package pacman.states;

import java.util.ArrayList;

import pacman.controllers.examples.DataContext;
import pacman.controllers.examples.MyPacmanController;
import pacman.controllers.examples.NearestPillPacMan;
import pacman.controllers.examples.NearestPillPacManVS;
import pacman.controllers.examples.RETURNVALUE;
import pacman.game.Game;
import pacman.game.Constants.DM;
import pacman.game.Constants.MOVE;

public class EatState extends BTState {
	
	//return rinning,fali,succes
	
	RETURNVALUE returnVal;
	//NearestPillPacManVS nearestPill;
	MOVE returnMove;
	DataContext data;

	
	public EatState(MyPacmanController controller)
	{
		super(controller);
		this.controller = controller;
		data = new DataContext(controller);
			
	}
	@Override
	public RETURNVALUE GetReturnvalue()
	{
		if(returnMove != null ||returnMove != MOVE.NEUTRAL)
		{
			return RETURNVALUE.RUNNING;
		}
		else 
		return RETURNVALUE.SUCCESS;
	}
	
	@Override
	public MOVE GetMove(Game game)
	{
		boolean check = (data.CheckMoveToNearestPill(game));
		System.out.println("simon says "+returnValue);
		
		if(check == true && data.IsGhostToClose(game)==false)
		{
			returnValue = RETURNVALUE.RUNNING;
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
			//returnValue = RETURNVALUE.SUCCESS;
			
			//check = (data.CheckMoveToNearestPill(game));
			//if(check == false)
			//{
			//	System.out.println("simon says im here");
			//	returnValue = RETURNVALUE.FAILIURE;
			//	//break;
			//}		
			//System.out.println("simon says "+returnValue);
			returnMove = game.getNextMoveTowardsTarget(current,game.getClosestNodeIndexFromNodeIndex(current,targetsArray,DM.PATH),DM.PATH);
		}
		if(data.CheckMoveToNearestPill(game)== false)
		{
			returnValue = RETURNVALUE.SUCCESS;
		}
		if(data.IsGhostToClose(game)==true)
		{
			returnValue = RETURNVALUE.FAILIURE;
			returnMove = null; 
					//controller.move;
		}
		//else	
			//returnValue = RETURNVALUE.FAILIURE;
		
		System.out.println("simon says eat");
		//System.out.println("simon says "+returnValue);
		//returnMove = data.MoveToNearestPill(game);		
		//returnValue = data.returnValue;		
		return returnMove;	
	}

}
