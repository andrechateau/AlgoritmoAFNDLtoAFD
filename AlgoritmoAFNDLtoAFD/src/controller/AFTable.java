/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import algoritmoafndltoafd.model.interfaces.DeltaTable;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Andre Chateaubriand
 */
class AFTable implements DeltaTable {

    private List<String> symbols;
    private List<String> states;

    public AFTable() {
        symbols = new LinkedList<>();
        states = new LinkedList<>();
    }

    @Override
    public List<String> getStates() {
        return states;
    }

    @Override
    public List<String> getSymbols() {
        return symbols;
    }

    public void addState(String state) {
        states.add(state);
    }

    public void addState(List<String> states) {
        states.addAll(states);
    }

    public void addSymbols(String symbol) {
        states.add(symbol);
    }

    public void addSymbols(List<String> symbols) {
        states.addAll(symbols);
    }


}
