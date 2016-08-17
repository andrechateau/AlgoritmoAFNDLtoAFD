/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import algoritmoafndltoafd.model.interfaces.DeltaDTable;
import java.util.HashMap;

/**
 *
 * @author Andre Chateaubriand
 */
public class DTable extends AFTable implements DeltaDTable {

    private HashMap<KeyPair, String> closure;

    public DTable() {
        super();
        closure = new HashMap<>();
    }

    @Override
    public String getClosure(String state, String symbol) {
        return closure.get(state);
    }

    public void addTransition(String keyState, String keySymbol, String outState) {
        closure.put(new KeyPair(keyState, keySymbol), outState);
    }

}
