/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoafndltoafd.model;

import java.util.ArrayList;

/**
 *
 * @author Otavio
 */
public class FiniteAutomaton {

    private ArrayList<State> states = new ArrayList<>();
    private ArrayList<String> inputAlphabet = new ArrayList<>();

    public FiniteAutomaton() {

    }

    public FiniteAutomaton(ArrayList<State> states, ArrayList<String> inputAlphabet, ArrayList<Transition> transitions) {
        this.states = states;
        this.inputAlphabet = inputAlphabet;
    }
    /**
     * get the list of final sates in finite automaton
     * @return the list of all final states in automaton
     */
    public ArrayList<State> getSetOfFinalStates() {
        ArrayList<State> setOfFinalStates = new ArrayList<>();
        for (State state : states) {
            if (state.isIsFinalState()) {
                setOfFinalStates.add(state);
            }
        }
        return setOfFinalStates;
    }
    /**
     * get the start state in finite automaton
     * @return the initial state
     */
    public State getStartState() {
        for (State state : states) {
            if (state.isIsStartState()) {
                return state;
            }
        }
        return null;
    }
    /**
     * Add a state to the list of states
     * @param state 
     */
    public void addState(State state){
        states.add(state);
    }
    /**
     * Add a symbol to input alphabet
     * @param symbol 
     */
    public void addSymbol(String symbol){
        inputAlphabet.add(symbol);
    }

}
