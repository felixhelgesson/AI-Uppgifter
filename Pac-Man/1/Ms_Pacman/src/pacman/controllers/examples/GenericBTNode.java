package pacman.controllers.examples;

import pacman.game.Constants.MOVE;
import pacman.game.Game;

public interface GenericBTNode {
	
	public RETURNVALUE procsess(Game game);
	public BTNode procsessB(Game game);

	MOVE getMove();

	//RETURNVALUE procsess(BTNode currentNode);
	
}
