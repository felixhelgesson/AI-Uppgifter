package pacman.states;

import pacman.controllers.Controller;
import pacman.controllers.examples.DataContext;
import pacman.controllers.examples.MyPacmanController;
import pacman.controllers.examples.RETURNVALUE;
import pacman.game.Constants.MOVE;
import pacman.game.Game;

public class BTState  {

	MOVE currentMove;
	RETURNVALUE currentReturnValue;
	protected DataContext data;
	public RETURNVALUE returnValue;
	protected MyPacmanController controller;
	
	public BTState(MyPacmanController controller)
	{
		this.controller = controller;
	}
	
	public RETURNVALUE GetReturnvalue()
	{
		return null;
	}
	
	public MOVE GetMove()
	{
		//return null;
		return MOVE.UP;
		//return MOVE.LEFT;
		//return MOVE.RIGHT
		//return null;
	}

	public MOVE GetMove(Game game) {
		// TODO Auto-generated method stub
		return null;
	}

}
