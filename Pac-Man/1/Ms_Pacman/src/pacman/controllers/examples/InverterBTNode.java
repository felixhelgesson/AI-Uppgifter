package pacman.controllers.examples;

import java.util.ArrayList;

import pacman.game.Game;

public class InverterBTNode extends BTNode {
	
	ArrayList<BTNode> childs;
	BTNode parent;
	
	public InverterBTNode(ArrayList<BTNode> childs, BTNode parent, MyPacmanController controller)
	{
		super(childs, parent, controller);
		
		this.childs = childs;
		this.parent = parent;
		this.controller = controller;
	}
	
	@Override
	public BTNode procsessB(Game game)
	{
		returnValue = RETURNVALUE.RUNNING;	
		for(int i = 0; i<childs.size(); ++i)
		{
			current_Node = childs.get(i).procsessB(game);
			returnValue = current_Node.returnValue;
			
			if(returnValue == RETURNVALUE.FAILIURE)
			{
				returnValue= RETURNVALUE.SUCCESS;
			}
			else if(returnValue == RETURNVALUE.SUCCESS)
			{
				returnValue= RETURNVALUE.FAILIURE;
			}
		}
		return this;
	}
	
	@Override
	public RETURNVALUE procsess(Game game) {
		
		controller.current_node = this;
		
		for(int i = 0; i< childs.size();++i)
		{
			if(childs.get(i).procsess(game) == RETURNVALUE.SUCCESS)
			{
				return RETURNVALUE.FAILIURE;			
			}
			
			if(childs.get(i).procsess(game) == RETURNVALUE.FAILIURE)
			{
				return RETURNVALUE.SUCCESS;			
			}
			
			if(childs.get(i).procsess(game) == RETURNVALUE.RUNNING)
			{
				return RETURNVALUE.RUNNING;			
			}
		}
		// TODO Auto-generated method stub
		return null;
	}
}
