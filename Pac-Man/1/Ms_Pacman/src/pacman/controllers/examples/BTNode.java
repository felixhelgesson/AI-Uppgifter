package pacman.controllers.examples;

import java.util.ArrayList;

import pacman.game.Constants.MOVE;
import pacman.game.Game;

public class BTNode implements GenericBTNode{

	ArrayList<BTNode> childs;
	BTNode parent;
	protected RETURNVALUE returnValue;
	protected BTNode current_Node;
	
	public MOVE move;
	
	DataContext data;
	MyPacmanController controller;
	
	public BTNode(ArrayList<BTNode> childs, BTNode parent,MyPacmanController controller)
	{
		this.childs = childs;
		this.parent = parent;
		this.controller = controller;
	}
	
	public void Add(BTNode child)
	{
		childs.add(child);
	}
	
	public void AddParent(BTNode parent)
	{
		this.parent = parent;
	}
	
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
		return null;
	}

	@Override
	public RETURNVALUE procsess(Game game) {
		// TODO Auto-generated method stub
		
		 move = MOVE.RIGHT;
		return null;
	}
}
