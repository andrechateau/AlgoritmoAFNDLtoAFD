/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import algoritmoafndltoafd.model.interfaces.DeltaNDTable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Andre Chateaubriand
 */
public class NDTable extends AFTable implements DeltaNDTable {

    private HashMap<KeyPair, List<String>> closure;

    public NDTable() {
        super();
        closure = new HashMap<KeyPair, List<String>>();
    }

    @Override
    public List<String> getClosure(String state, String symbol) {
        return closure.get(state);

    }

    public void addTransition(String keyState, String keySymbol, List<String> outState) {
        closure.put(new KeyPair(keyState, keySymbol), outState);
    }

    public void addTransition(String keyState, String keySymbol, String outState) {
        KeyPair key = new KeyPair(keyState, keySymbol);
        if (!closure.containsKey(key)) {
            closure.put(key, new LinkedList<String>());
        }
        closure.get(key).add(outState);
    }
}
