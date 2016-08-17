/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import algoritmoafndltoafd.model.interfaces.DeltaNDLTable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Andre Chateaubriand
 */
public class NDLTable extends NDTable implements DeltaNDLTable {

    private HashMap<String, List<String>> lambdaClosure;

    public NDLTable() {
        super();
        lambdaClosure = new HashMap<String, List<String>>();
    }

    @Override
    public List<String> getLClosure(String state) {
        return lambdaClosure.get(state);
    }

    public void addLambdaClosure(String keyState, List<String> outState) {
        lambdaClosure.put(keyState, outState);
    }

    public void addLambdaClosure(String keyState, String outState) {
        if (!lambdaClosure.containsKey(keyState)) {
            lambdaClosure.put(keyState, new LinkedList<String>());
        }
        lambdaClosure.get(keyState).add(outState);
    }

}
