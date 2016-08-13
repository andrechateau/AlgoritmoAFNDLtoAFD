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
public class State {
    private String name;
    private boolean isFinalState;
    private boolean isStartState;

    public State(String name, boolean isFinalState, boolean isStartState) {
        this.name = name;
        this.isFinalState = isFinalState;
        this.isStartState = isStartState;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the isFinalState
     */
    public boolean isIsFinalState() {
        return isFinalState;
    }

    /**
     * @return the isStartState
     */
    public boolean isIsStartState() {
        return isStartState;
    }
    
}
