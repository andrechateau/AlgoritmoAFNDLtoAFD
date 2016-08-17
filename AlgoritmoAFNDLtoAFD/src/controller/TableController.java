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
        throw new RuntimeException("TODO");
    }

    public static DeltaTable getNDLTable(AFND aflambda) {
        throw new RuntimeException("TODO");
    }

    private static List<String> getStringClosure(List<State> states) {
        List<String> list = new ArrayList<String>();
        for (String string : list) {
            list.add(string);
        }
        Collections.sort(list);
        return list;
    }
}
