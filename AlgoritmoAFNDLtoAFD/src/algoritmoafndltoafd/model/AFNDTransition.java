/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoafndltoafd.model;

import java.util.ArrayList;
import java.util.List;

/**
 *  This class represents a transition of Finite automaton not deterministic. 
 *  The diference between this class and FADTransition is the number of target state
 *  this class has a list of target states, the other just use one target state
 *  
 * @author Otavio
 */
public class AFNDTransition extends Transition{
    private ArrayList<State> targetStates;
    public AFNDTransition(){
        targetStates = new ArrayList<>();
    }
    public AFNDTransition(ArrayList<State> targetStates) {
        this.targetStates = targetStates;
    }
    
    public void addTargetState(State state){
        targetStates.add(state);
    }
    
    public List<State> getTargetStates(){
        return targetStates;
    }
}
