package pacman.controllers.examples;

import pacman.controllers.Controller;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import pacman.states.BTState;

public class MyPacmanController extends Controller<MOVE> {
	
	public BTNode current_node;
	DataContext dataContext;
	BTState currentState;
	BehaviorTree btTree;
	RETURNVALUE returnvalue;
	public MOVE move,returnMove;

	public MyPacmanController()
	{
		btTree = new BehaviorTree(this, null);			
		btTree.initi();
		dataContext = new DataContext(this);
	}
	
	protected void Reset()
	{
		
	}
	//called all time
	@Override
	public MOVE getMove(Game game, long timeDue) {
		
		
		returnvalue = btTree.Execute(game);
		
		return move;
	}
	


}
