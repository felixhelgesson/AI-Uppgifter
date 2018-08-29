package pacman.states;

import pacman.controllers.examples.DataContext;
import pacman.controllers.examples.MyPacmanController;
import pacman.controllers.examples.NearestPillPacMan;
import pacman.controllers.examples.NearestPillPacManVS;
import pacman.controllers.examples.RETURNVALUE;
import pacman.game.Game;
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
		returnValue = RETURNVALUE.RUNNING;	
		//System.out.println("simon says "+returnValue);
		returnMove = data.MoveToNearestPill(game);		
		returnValue = data.returnValue;
		
		return returnMove;	
	}

}
