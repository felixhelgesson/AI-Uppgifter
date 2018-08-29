package pacman.controllers.examples.Assignment;

import pacman.game.Constants.MOVE;
import pacman.game.Game;


public class BTState {
	
	DataContext data;
	Game state;

	public BTState(Game state, DataContext data)
	{
		this.state = state;
		this.data = data;
				
	}
	
	public void UpdateState(Game state)
	{
		this.state = state;
	}
	
	public RETURNVALUE getProcess()
	{
		return null;
	}
	
	public MOVE UpdatePerseption()
	{
		return MOVE.NEUTRAL;
	}
	
	public MOVE getNextMove(Game state, int TargetPos)
	{
		return MOVE.NEUTRAL;
	}

	
	
	
	

	
	

}
