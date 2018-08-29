/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ANN;
import java.util.ArrayList;
import java.lang.*;


public class Neuron {
    
    float input;
    float output;
    float threshold;
    float weightedSum;
    
public Neuron(float Threshold, float Input)
{
    input = Input;
    threshold = Threshold;
    output = 0;
    weightedSum = 0;
}

public float PassOutput()
{
    weightedSum =  (float)Sigmoid(output, 1);
    output = weightedSum;
    input = weightedSum;
    return weightedSum;
   
}

public float Output()
{
    return output;
}

double Sigmoid(float netinput, float response)
{
    return ( 1 / ( 1 + Math.exp(-netinput / response)));
}




  
    
}
