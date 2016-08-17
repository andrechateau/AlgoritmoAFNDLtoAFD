/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoafndltoafd.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Otavio
 */
public class State implements Comparable<State> {

    private String name;
    private boolean isFinalState;
    private boolean isStartState;
    private ArrayList<Transition> transitions;

    public State(String name, boolean isFinalState, boolean isStartState, ArrayList<Transition> transitions) {
        this.name = name;
        this.isFinalState = isFinalState;
        this.isStartState = isStartState;
        this.transitions = transitions;
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

    /**
     * @return the transitions
     */
    public ArrayList<Transition> getTransitions() {
        return transitions;
    }

    public Set<State> getClosure(String symbol) {
        Set<State> closure = new HashSet<>();
        for (Transition transition : transitions) {
            if (transition instanceof AFNDTransition) {
                AFNDTransition t = (AFNDTransition) transition;
                closure.addAll(t.getTargetStates());
            } else if (transition instanceof AFDTransition) {
                AFDTransition t = (AFDTransition) transition;
                closure.add(t.getTargetState());
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof State)) {
            return false;
        }
        State state = (State) o;
        return state.getName().equals(name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public int compareTo(State o) {
        return this.name.compareTo(o.getName());
    }

}
