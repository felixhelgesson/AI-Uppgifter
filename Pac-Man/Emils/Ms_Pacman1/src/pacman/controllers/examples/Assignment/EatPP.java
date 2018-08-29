package pacman.controllers.examples.Assignment;

import pacman.game.Game;
import pacman.game.Constants.DM;



public class EatPP extends BTState {

	int[] powerPills;
	int powerPill;
	int closestPill;
	int path;

		
	public EatPP(Game state, DataContext data) {
		super(state, data);
		// TODO Auto-generated constructor stub
	}
	
	public void UpdateState(Game state)
	{
		this.state = state;
	}
	
	@Override
	public RETURNVALUE getProcess()
	{
				
		powerPills = data.PowerPills(state);
		closestPill = data.ClosestPP(state);
		path = state.getShortestPathDistance(state.getPacmanCurrentNodeIndex(), closestPill);
			
		if(powerPills.length > 0 && path < 40 && path > 0)
		{
		    System.out.println("eatPP");


			data.SetCurrentMove(state.getNextMoveTowardsTarget(state.getPacmanCurrentNodeIndex(),
					state.getClosestNodeIndexFromNodeIndex(state.getPacmanCurrentNodeIndex(),powerPills,DM.PATH),DM.PATH));
			
			return RETURNVALUE.RUNNING;		
		}
                
               
	
			
		return RETURNVALUE.SUCCESS;	
		

	}
	
	
	

	
	

}
