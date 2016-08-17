/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import algoritmoafndltoafd.model.AFD;
import algoritmoafndltoafd.model.AFND;
import algoritmoafndltoafd.model.State;
import algoritmoafndltoafd.model.interfaces.DeltaDTable;
import algoritmoafndltoafd.model.interfaces.DeltaTable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Andre Chateaubriand
 */
public final class TableController {

    private TableController() {
        throw new AssertionError();
    }

    public static DeltaTable getDTable(AFD afd) {
        DTable d = new DTable();
        d.addState(getStringClosure(afd.getStates()));
        d.addSymbols(afd.getInputAlphabet());
        for (State state : afd.getStates()) {
            for (String symbol : afd.getInputAlphabet()) {
                List<String> l = state.getStringClosure(symbol);
                if (l.size() >= 1) {
                    d.addTransition(state.getName(), symbol, l.get(0));
                }

            }
        }
        return d;
    }

    public static DeltaTable getNDTable(AFND afnd) {
        NDTable d = new NDTable();
        d.addState(getStringClosure(afnd.getStates()));
        d.addSymbols(afnd.getInputAlphabet());
        for (State state : afnd.getStates()) {
            for (String symbol : afnd.getInputAlphabet()) {
                List<String> l = state.getStringClosure(symbol);
                d.addTransition(state.getName(), symbol, l);
            }
        }

        return d;
    }

    public static DeltaTable getNDLTable(AFND aflambda) {
        NDLTable d = new NDLTable();
        d.addState(getStringClosure(aflambda.getStates()));
        d.addSymbols(aflambda.getInputAlphabet());
        for (State state : aflambda.getStates()) {
            for (String symbol : aflambda.getInputAlphabet()) {
                List<String> l = getClosureWhithoutLambda(aflambda);
                d.addTransition(state.getName(), symbol, l);
            }
        }
        for (State state : aflambda.getStates()) {
            d.addLambdaClosure(state.getName(), state.getLambdaClosure());
        }
        return d;
    }

    private static List<String> getStringClosure(List<State> states) {
        List<String> list = new ArrayList<String>();
        for (String string : list) {
            list.add(string);
        }
        Collections.sort(list);
        return list;
    }

    /* private static List<String> getLambdaClosure(AFND afnd) {
        throw new RuntimeException();
    }*/
    private static List<String> getClosureWhithoutLambda(AFND afnd) {
        throw new RuntimeException();
    }
}
