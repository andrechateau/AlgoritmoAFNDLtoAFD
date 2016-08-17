/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Andre Chateaubriand
 */
public class Cell {

    private String symbol;
    private String state;
    private Set<String> closure;

    public Cell(String symbol, String state, List<String> closure) {
        this.symbol = symbol;
        this.state = state;
        this.closure = new TreeSet<>();
        this.closure.addAll(closure);
    }

    public Cell() {
        symbol = "";
        state = "";
        closure = new TreeSet<String>();
    }

    /**
     * @return the symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * @param symbol the symbol to set
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the closure
     */
    public Set<String> getClosure() {
        return closure;
    }

    /**
     * @param closure the closure to set
     */
    public void setClosure(Set<String> closure) {
        this.closure = closure;
    }

}
