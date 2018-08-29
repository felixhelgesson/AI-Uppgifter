package pacman.controllers.examples;

import pacman.controllers.Controller;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import pacman.states.BTState;
import pacman.states.ChaseState;
import pacman.states.EatState;
import pacman.states.SurviveState;

public class MyPacmanController extends Controller<MOVE> {
	
	public BTNode current_node;
	DataContext dataContext;
	BTState currentState;
	BehaviorTree btTree;
	RETURNVALUE returnvalue;
	public MOVE move,returnMove;
	SurviveState test;
	ChaseState test2;
	EatState test3;

	public MyPacmanController()
	{
		btTree = new BehaviorTree(this, null);			
		btTree.initi();
		dataContext = new DataContext(this);
		test = new SurviveState(this);
		test2 = new ChaseState(this);
		test3 = new EatState(this);
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
