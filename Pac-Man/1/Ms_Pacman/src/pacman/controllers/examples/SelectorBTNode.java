package pacman.controllers.examples;

import java.util.ArrayList;

import pacman.game.Constants.MOVE;
import pacman.game.Game;

public class SelectorBTNode extends BTNode {

	ArrayList<BTNode> childs;
	BTNode parent;
	//RETURNVALUE returnValue;
	//BTNode current_Node;
	//public MOVE move = MOVE.NEUTRAL;
	
	public SelectorBTNode(ArrayList<BTNode> childs, BTNode parent, MyPacmanController controller)
	{
		super(childs, parent, controller);
		
		this.childs = childs;
		this.parent = parent;
		this.controller = controller;
	}
	@Override
	public void currentNode(BTNode currentNode)
	{
		currentNode = this;
	}
	
	@Override
	public MOVE getMove()
	{
		return null;
	}
	
	@Override
	public BTNode procsessB(Game game)
	{
		returnValue = RETURNVALUE.RUNNING;	
		for(int i = 0; i<childs.size(); ++i)
		{
			current_Node = childs.get(i).procsessB(game);
			returnValue = current_Node.returnValue;
			
			if(returnValue == RETURNVALUE.SUCCESS||returnValue == RETURNVALUE.RUNNING)
			{
				break;
			}
		}
		return this;
	}
	
	@Override
	public RETURNVALUE procsess(Game game) {
		// TODO Auto-generated method stub

		controller.current_node = this;
		
		for(int i = 0; i<childs.size(); ++i)
		{
			if(childs.get(i).procsess(game) == RETURNVALUE.SUCCESS)
			{
				return RETURNVALUE.SUCCESS;
			}
			if(childs.get(i).procsess(game) == RETURNVALUE.RUNNING)
			{
				return RETURNVALUE.RUNNING;
			}
		}
		//move = MOVE.NEUTRAL;
		
		return RETURNVALUE.FAILIURE;		
		//return null;
	}
}