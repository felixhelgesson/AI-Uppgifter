package pacman.controllers.examples;

import java.util.ArrayList;

import pacman.game.Constants.MOVE;
import pacman.game.Game;
import pacman.states.BTState;

public class LeafBTNode extends BTNode {
	
	ArrayList<BTNode> childs;
	BTNode parent;
	
	public RETURNVALUE myValue;
	
	BTState mystate;
	MOVE move;
	
	DataContext data;
	
	public LeafBTNode(ArrayList<BTNode> childs, BTNode parent,BTState mystate, MyPacmanController controller)
	{
		super(childs, parent, controller);
		
		this.controller = controller;
		this.childs = childs;
		this.parent = parent;
		this.mystate = mystate;		
		data = new DataContext(controller);
	}	
	
	public MOVE GetMove(Game game)
	{
		return mystate.GetMove(game);
	}
	
	public BTNode procsessB(Game game)
	{		
		controller.move = mystate.GetMove(game);	
		returnValue = mystate.returnValue; 		
		return this;
	}
	
	@Override
	public RETURNVALUE procsess(Game game) {
		
		controller.current_node = this;
		controller.move = mystate.GetMove(game);

		
		return mystate.GetReturnvalue();
	}
	

}
