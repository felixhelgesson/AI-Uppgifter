/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ANN;
import ANN.Neuron;

/**
 *
 * @author Emil
 */
public class Weight {
    
    float weight;
    Neuron n1;
    Neuron n2;
    
    public Weight(Neuron n1, Neuron n2, float weight)
    {
        this.n1 = n1;
        this.n2 = n2;
        this.weight = weight; 
    }
    
    public void Calculate()
    {       
        n2.output +=  (n1.input*weight);
    }
    
    public void Reset()
    {
        n1.input = 0;
        n2.output = 0;
    }
    
    public void SetWeight(float newWeigth)
    {
        weight = newWeigth;
    }
    
}
