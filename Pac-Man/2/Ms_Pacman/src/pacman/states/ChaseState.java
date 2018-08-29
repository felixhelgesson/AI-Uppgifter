package pacman.states;

import pacman.controllers.examples.DataContext;
import pacman.controllers.examples.MyPacmanController;
import pacman.controllers.examples.RETURNVALUE;
import pacman.game.Game;
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
		returnValue = RETURNVALUE.RUNNING;
		returnMove = data.GetNearestPowerPill(game);	
		returnValue = data.returnValue;
		if(returnValue == RETURNVALUE.RUNNING)
			System.out.println("yes");
			
		return returnMove;
	}

}
