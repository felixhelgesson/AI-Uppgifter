package pacman.controllers.examples.Assignment;

import pacman.game.Constants;
import pacman.game.Game;
import pacman.game.Constants.DM;

public class DeafaultState extends BTState {
	
	
	int[] pills;
        int pathToGhost;
	
	public DeafaultState(Game state, DataContext data)
	{
		super(state,data);
		
	}
	
	@Override
	public void UpdateState(Game state)
	{
		this.state = state;
	}
	
	@Override
	public RETURNVALUE getProcess()
	{
		pills = data.Pills(state);
                	
		if(pills.length > 0 && data.CheckEscape(state) == false )
		{
		    //System.out.println("deafault");
	            data.SetCurrentMove(state.getNextMoveTowardsTarget(state.getPacmanCurrentNodeIndex(),
                    state.getClosestNodeIndexFromNodeIndex(state.getPacmanCurrentNodeIndex(),pills,DM.PATH),DM.PATH));
	            return RETURNVALUE.RUNNING;
		}
		
		return RETURNVALUE.FAILURE;
	}
	


}
