/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ANN;

import java.util.ArrayList;
import pacman.controllers.Controller;
import pacman.game.Constants;
import pacman.game.Constants.MOVE;
import pacman.game.Game;

public class ANNController extends Controller<MOVE>
{
        public  NeuralNet aNN;
        public DataContextAnn data;
        float in1, in2, in3;

    public ANNController()
    {
        data = new DataContextAnn();
        //aNN = new NeuralNet(0.4f, 1, 2);
        aNN = new NeuralNet(0, 0, 0);
   
    }
    
    
    @Override
	public MOVE getMove(Game game, long timeDue)
        {
            data.proccessGameState(game);
            //gör input talen i neuralnet klassen istället 
            aNN.runANN();
            in1 = data.Input1(game);
            in2 = data.Input2(game);
            in3 = data.Input3(game);
            aNN.SetInput(in1, in2, in3);
            
        float temp = 0; 
        MOVE currentMove = MOVE.NEUTRAL;
        
        if(aNN.out1.output > temp)
        {
            //System.out.println("neuron1");
            temp = aNN.out1.output;
            currentMove = game.getNextMoveAwayFromTarget(game.getPacmanCurrentNodeIndex(),
                    game.getGhostCurrentNodeIndex(data.ghostNode), Constants.DM.PATH);
        }
        if(aNN.out2.output > temp)
        {
            //System.out.println("neuron2");
            temp = aNN.out2.output;
            currentMove = game.getNextMoveTowardsTarget(game.getPacmanCurrentNodeIndex(),
                                game.getClosestNodeIndexFromNodeIndex(game.getPacmanCurrentNodeIndex(),
                                        data.PowerPills(game),Constants.DM.PATH),Constants.DM.PATH);
        }
        if(aNN.out3.output > temp)
        {
            //temp = aNN.out3.outpu
            //System.out.println("neuron3");
            currentMove = game.getNextMoveTowardsTarget(game.getPacmanCurrentNodeIndex(),
                                game.getClosestNodeIndexFromNodeIndex(game.getPacmanCurrentNodeIndex(),
                                        data.Pills(game),Constants.DM.PATH),Constants.DM.PATH);
        }
            

            //System.out.println("input1 " +in1);
            //System.out.println("input2 " +in2);
            //System.out.println("input3 " +in3);
        
            //Kolla så alla metorder är rätt med survie
       
            
            return currentMove;
        }
}
