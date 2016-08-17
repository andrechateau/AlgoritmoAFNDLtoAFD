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
public abstract class Transition {

    private State originState;
    private String symbol;
    
    public void setOriginState(State originState){
        this.originState = originState;
    }
    public void setSybol(String symbol){
        this.symbol = symbol;
    }
    /**
     * @return the originState
     */
    public State getOriginState() {
        return originState;
    }

    /**
     * @return the symbol
     */
    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return "("+originState.getName()+","+symbol+")->";
    }
    
}
