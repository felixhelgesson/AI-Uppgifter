package pacman.controllers.examples.Assignment;

import pacman.controllers.Controller;
import pacman.game.Constants.MOVE;
import pacman.game.Game;

public class AssignmentController extends Controller<MOVE> {

	BTNode current_node;
	Sequence root;
	LeafNode surviveNode, eatPPNode, huntNode, deafaultNode; 
	Game current_state;
	BTState survive, hunt, eatPP, deafault; 
	DataContext data;
	
	public AssignmentController(){
			
		this.data = new DataContext();
		survive = new Survive(current_state, data);
		hunt = new Hunt(current_state, data);
		eatPP = new EatPP(current_state,data);
		deafault = new DeafaultState(current_state, data);
		
		root = new Sequence();		
		surviveNode = new LeafNode(survive);
		eatPPNode = new LeafNode(eatPP);
		huntNode = new LeafNode(hunt);
		deafaultNode = new LeafNode(deafault);
				
		this.current_node = root;
		root.addChild(surviveNode);	
		root.addChild(huntNode);			
		root.addChild(deafaultNode);
		
	}
	
	public void Reset()
	{
		
		this.current_node = root;
	}
	
	@Override
	public MOVE getMove(Game game, long timeDue) {
		// TODO Auto-generated method stub
		this.current_state = game;
		
		survive.UpdateState(current_state);
		hunt.UpdateState(current_state);
		eatPP.UpdateState(current_state);
		deafault.UpdateState(current_state);
		
		this.data.proccessGameState(game);
		current_node = current_node.process();
		RETURNVALUE res = this.current_node.nodeState();
		
		switch(res)
		{
		case FAILURE:
			Reset();
			break;
		case SUCCESS:
			Reset();
			break;
		case RUNNING:
			//System.out.println("hej");
			break;
		
		}
			
                //System.out.println();

		return data.GetCurrentMove();
		
		
	
		
		
		
	}

}
