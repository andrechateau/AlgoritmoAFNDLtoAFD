/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoafndltoafd.model;

/**
 *
 * @author Otavio
 */
public class AFDTransition extends Transition {
    private State targetState;

    /**
     * @return the targetState
     */
    public State getTargetState() {
        return targetState;
    }

    /**
     * @param targetState the targetState to set
     */
    public void setTargetState(State targetState) {
        this.targetState = targetState;
    }
    
    
}
