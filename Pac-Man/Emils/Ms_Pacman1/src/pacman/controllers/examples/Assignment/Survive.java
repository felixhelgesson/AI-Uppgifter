package pacman.controllers.examples.Assignment;

import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Game;
import pacman.controllers.examples.Assignment.DataContext;


public class Survive extends BTState {
	
	public Survive(Game state, DataContext data) {
		super(state, data);
		// TODO Auto-generated constructor stub
	}

	int ghostPos;
	GHOST ghostes;
	int pacPos;
	int path;
	

	public void UpdateState(Game state)
	{
		this.state = state;
	}
	
	@Override
	public RETURNVALUE getProcess()
	{
	
                if(data.CheckEscape(state) == true)
		{
     		  data.SetCurrentMove(state.getNextMoveAwayFromTarget(state.getPacmanCurrentNodeIndex(), state.getGhostCurrentNodeIndex(data.G()), state.getPacmanLastMoveMade(), DM.MANHATTAN));
		  //System.out.println("survive");

		   return RETURNVALUE.RUNNING;
		}
                             				 					
		return RETURNVALUE.SUCCESS;
	}
	


	
	

}
