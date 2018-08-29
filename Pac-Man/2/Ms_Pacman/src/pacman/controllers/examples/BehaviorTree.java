package pacman.controllers.examples;

import java.util.ArrayList;

import pacman.game.Constants.MOVE;
import pacman.game.Game;
import pacman.states.BTState;
import pacman.states.ChaseState;
import pacman.states.EatPPState;
import pacman.states.EatState;
import pacman.states.SurviveState;

public class BehaviorTree {
	
	//public BTNode root = null;
	 
	//SelectorBTNode root;	
	SequenceBTNode root;
	InverterBTNode surviveInverter;
	SequenceBTNode powerPillSequence;
	
	LeafBTNode survive, chase, eat, eatPP;
	BTState currentState;
	
	DataContext data;
	
	MOVE currentMove;
	
	BTNode current_Node;
	
	MyPacmanController controller;
	
	EatState eatState;
	SurviveState surviveState;
	ChaseState chaseState;
	EatPPState eatPPState;
	
	RETURNVALUE returnVal = RETURNVALUE.FAILIURE;
	
	public BehaviorTree(MyPacmanController controller,DataContext data)
	{
		this.controller = controller;
		this.data = data;
		
	}

	public void initi()
	{
		eatState = new EatState(controller);
		surviveState = new SurviveState(controller);
		chaseState = new ChaseState(controller);
		
		ArrayList<BTNode> rootList = new ArrayList<BTNode>();
		
		survive = new LeafBTNode(new ArrayList<BTNode>(),null,surviveState,controller);
		chase = new LeafBTNode(new ArrayList<BTNode>(),null,chaseState,controller);
		eat = new LeafBTNode(new ArrayList<BTNode>(),null,eatState,controller);
	
		rootList.add(survive);
		rootList.add(chase);
		rootList.add(eat);
		
		root = new SequenceBTNode(rootList,null,controller);		
		
	}
	
	public RETURNVALUE Execute(Game game)
	{
		
		root.procsessB(game);
		
		switch(returnVal)
		{
		case FAILIURE:
			current_Node = root.procsessB(game);
			returnVal = current_Node.returnValue;
			break;
		case SUCCESS:
			current_Node = root.procsessB(game);
			returnVal = current_Node.returnValue;
			break;
		case RUNNING:
			break;
		default:
			current_Node = root.procsessB(game);
			returnVal = current_Node.returnValue;
			break;
		
		}
		return current_Node.returnValue;
	}
}
