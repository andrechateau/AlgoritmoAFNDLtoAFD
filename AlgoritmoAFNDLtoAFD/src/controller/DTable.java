/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import algoritmoafndltoafd.model.interfaces.DeltaDTable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Andre Chateaubriand
 */
public class DTable extends AFTable implements DeltaDTable {

    private HashMap<KeyPair, String> closure;
    private Table table;

    public DTable() {
        super();
        closure = new HashMap<>();
    }

    @Override
    public String getClosure(String state, String symbol) {
        String a = getEstado(table.getList(state, symbol));
        return a.equals("<>") ? "-" : a;
        //return closure.get(state);
    }

    public void addTransition(String keyState, String keySymbol, String outState) {
        closure.put(new KeyPair(keyState, keySymbol), outState);
    }

    @Override
    public String toString() {
        String r = "";
        r += "==========================================================================================\n";
        List<String> states = getStates();
        ///HEAD
        r += "\t";
        r += String.format("%-18s", "");
        for (String symbol : getSymbols()) {
            r += String.format("%-25s", symbol);
        }
        r += String.format("%s", "\n");
        /// LINHA
        for (String state : states) {
            r += String.format("%-18s", state) + "\t";
            for (String symbol : getSymbols()) {
                //r += String.format("%-18s", getClosure(state, symbol)) + "\t";
               /* if (table != null) {
                    r += String.format("%-18s", getEstado(table.getList(state, symbol))) + "\t";
                }*/
                r += String.format("%-18s", getClosure(state, symbol)) + "\t";

                //r += (getClosure(state, symbol)!=null ? getClosure(state, symbol).toString() : "") + "\t";
            }
            r += "\n";
        }
        r += "==========================================================================================\n";

        ////
        return r;
    }

    private static String getEstado(List<String> strings) {

        String r = "<";
        if (strings != null) {
            for (String string : strings) {
                r += string + ",";
            }
            if (strings.size() >= 1) {
                r = r.substring(0, r.length() - 1);
            }

        }
        r += ">";
        return r;
    }

    /**
     * @return the table
     */
    public Table getTable() {
        return table;
    }

    /**
     * @param table the table to set
     */
    public void setTable(Table table) {
        this.table = table;
    }

}
