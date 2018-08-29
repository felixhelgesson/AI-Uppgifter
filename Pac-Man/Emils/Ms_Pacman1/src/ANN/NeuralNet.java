/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ANN;
import pacman.controllers.Controller;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import java.util.ArrayList;
import java.util.Random;



/**
 *
 * @author Emil
 */
public class NeuralNet  
{
    
    Random rnd = new Random();
    public float inputValue1, inputValue2, inputValue3;
    
    public Neuron input1;
    public Neuron input2;
    public Neuron input3;
    
    public Neuron hidden1;
    public Neuron hidden2;
    
    
    public Neuron out1;
    public Neuron out2;
    public Neuron out3;
    
    public Weight w1;
    public Weight w2;
    public Weight w3;
    public Weight w4;
    public Weight w5;
    public Weight w6;
    public Weight w7;
    public Weight w8;
    public Weight w9;
    public Weight w10;
    public Weight w11;
    public Weight w12;
      
    public ArrayList<Weight> weights = new ArrayList<Weight>();
    
    public NeuralNet(float inputValue1, float inputValue2, float inputValue3)
    {
        
        SetInput(inputValue1, inputValue2,inputValue3);
        
        input1 = new Neuron(0,inputValue1);
        input2 = new Neuron(0,inputValue2);
        input3 = new Neuron(0,inputValue3);
 
        hidden1 = new Neuron(0.2f, 0);
        hidden2 = new Neuron(1.2f, 0);
        
        out1 = new Neuron(0.5f, 0);
        out2 = new Neuron(0.2f, 0);
        out3 = new Neuron(0.7f, 0);
        
        w1 = new Weight(input1, hidden1, 0.11f);
        w2 = new Weight(input1, hidden2, 0.56f);
        w3 = new Weight(input2, hidden1, 1f);
        w4 = new Weight(input2, hidden2, 0.98f);
        w5 = new Weight(input3, hidden1, 0.82f);
        w6 = new Weight(input3, hidden2, 0.4f);
        w7 = new Weight(hidden1, out1, 0.64f);
        w8 = new Weight(hidden1, out2, 0.3f);
        w9 = new Weight(hidden1, out3, 0.8f);
        w10 = new Weight(hidden2, out1, 0.23f);
        w11 = new Weight(hidden2, out2, 0.56f);
        w12 = new Weight(hidden2, out3, 0.9f);
        
        weights.add(w1);
        weights.add(w2);
        weights.add(w3);
        weights.add(w4);
        weights.add(w5);
        weights.add(w6);
        weights.add(w7);
        weights.add(w8);
        weights.add(w9);
        weights.add(w10);
        weights.add(w11);
        weights.add(w12);
    }
    
    public void SetInput(float inputValue1, float inputValue2, float inputValue3)
    {
        this.inputValue1 = inputValue1;
        this.inputValue2 = inputValue2;
        this.inputValue3 = inputValue3;
              
    }
    
    public float RandomNumber()
    {
        float start = 0;
        float end = 1;
        float random = new Random().nextFloat();
	float result = start + (random * (end - start));
        return result;
    }
    
    
    public MOVE runANN()
    {
        for (int i = 0; i < weights.size(); i++) 
        {
            weights.get(i).SetWeight(RandomNumber());
        }
     
        
        for (int i = 0; i < weights.size(); i++) 
        {
                weights.get(i).Reset();
        }
          
        input1.input = inputValue1;
        input2.input = inputValue2;
        input3.input = inputValue3;
                
        for (int i = 0; i < weights.size(); i++) 
        {
            weights.get(i).Calculate();
                    if(i == 6)
                    {
                        //System.out.println(hidden1.output);
                        //System.out.println(hidden2.output);
                        
                        hidden1.PassOutput();
                        hidden2.PassOutput();
                        
                       // System.out.println(hidden1.weightedSum);
                       // System.out.println(hidden2.weightedSum);

                    }
        }
        
        out1.PassOutput();
        out2.PassOutput();
        out3.PassOutput();
        
        System.out.println("node 1 " +out1.output);
        System.out.println("node 2 " +out2.output);
        System.out.println("node 3 " +out3.output);
        
        System.out.println("");
        
   

        return MOVE.NEUTRAL;
    }
    
}
     
