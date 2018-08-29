package pacman.states;

import pacman.controllers.examples.DataContext;
import pacman.controllers.examples.MyPacmanController;
import pacman.controllers.examples.RETURNVALUE;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;

public class SurviveState extends BTState {
	
	DataContext data;
	MOVE returnMove;
	
	public SurviveState(MyPacmanController controller)
	{
		super(controller);
		this.controller = controller;
		data = new DataContext(controller);
	}
	
	@Override
	public RETURNVALUE GetReturnvalue()
	{
		if(returnMove != null )//||returnMove != MOVE.NEUTRAL)
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
		//returnValue = RETURNVALUE.RUNNING;
		int current=game.getPacmanCurrentNodeIndex();
		for(GHOST ghost : GHOST.values())
			if(game.getGhostEdibleTime(ghost)==0 && game.getGhostLairTime(ghost)==0)
			{
				if(game.getShortestPathDistance(current,game.getGhostCurrentNodeIndex(ghost))<data.MIN_DISTANCE)
				{				
					returnValue = RETURNVALUE.RUNNING;
					//System.out.println("simon says 1 "+returnValue);
					return game.getNextMoveAwayFromTarget(game.getPacmanCurrentNodeIndex(),game.getGhostCurrentNodeIndex(ghost),DM.PATH);
				}			
				if(game.getShortestPathDistance(current,game.getGhostCurrentNodeIndex(ghost))>data.MIN_DISTANCE)
				{
					returnValue = RETURNVALUE.SUCCESS;
				}
			}
			else
			{
				//returnValue = RETURNVALUE.FAILIURE;
				//returnMove = controller.move;					
			}	
		System.out.println("simon says survive");
		System.out.println(returnValue);
		//return MOVE.RIGHT;
		//returnValue = RETURNVALUE.RUNNING;
		//returnMove = data.MoveFromNearestHostileGhost(game);
		//returnValue = data.returnValue;
		return controller.move;
	}
	
	

}
