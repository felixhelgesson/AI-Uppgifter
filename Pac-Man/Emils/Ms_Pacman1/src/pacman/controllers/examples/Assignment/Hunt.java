package pacman.controllers.examples.Assignment;

import pacman.game.Game;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;

public class Hunt extends BTState {

	public Hunt(Game state, DataContext data) {
		super(state,data);
		// TODO Auto-generated constructor stub
	}
	
	public int target;
	GHOST currentGhost;
	public int path;
	int test;
	
	
	public void UpdateState(Game state)
	{
		this.state = state;
	}
	
	@Override
	public RETURNVALUE getProcess()
	{	

            //System.out.println(data.ClosestEdibleGhost(state));
            if(data.ClosestEdibleGhost(state) == true)
            {
                   //data.SetCurrentMove(state.getNextMoveTowardsTarget(state.getPacmanCurrentNodeIndex(), state.getGhostCurrentNodeIndex(data.G()), DM.PATH));
		   System.out.println("hunting");
		   return RETURNVALUE.RUNNING;        			
            }
		return RETURNVALUE.SUCCESS;
	}
	
	

	
	
	

}
