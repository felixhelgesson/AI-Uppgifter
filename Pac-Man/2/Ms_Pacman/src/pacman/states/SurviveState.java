package pacman.states;

import pacman.controllers.examples.DataContext;
import pacman.controllers.examples.MyPacmanController;
import pacman.controllers.examples.RETURNVALUE;
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
		//return MOVE.RIGHT;
		returnValue = RETURNVALUE.RUNNING;
		returnMove = data.MoveFromNearestHostileGhost(game);
		returnValue = data.returnValue;
		return returnMove;
	}
	
	

}
