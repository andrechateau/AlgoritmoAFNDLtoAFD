/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import algoritmoafndltoafd.model.AFD;
import algoritmoafndltoafd.model.AFND;
import algoritmoafndltoafd.model.State;
import algoritmoafndltoafd.model.interfaces.DeltaTable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
        System.out.println("Non Deterministic");

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

    public static NDTable removeL(NDLTable tbin) {
        NDTable d = new NDTable();
        d.addState(tbin.getStates());
        d.addSymbols(tbin.getSymbols());
        for (String state : tbin.getStates()) {
            for (String symbol : tbin.getSymbols()) {
                List<String> l = getConversionClosure(tbin, state, symbol);
                d.addTransition(state, symbol, l);
            }
        }
        return d;
    }

    private static List<String> getConversionClosure(NDLTable tbin, String state, String symbol) {
        Set<String> set = new TreeSet<>();
        List<String> preLambda = tbin.getLClosure(state);
        for (String string : preLambda) {
            set.addAll(tbin.getClosure(string, symbol));
            for (String string1 : tbin.getClosure(string, symbol)) {
                set.addAll(tbin.getLClosure(string1));
            }

        }
        return new ArrayList<String>(set);
    }

    public static DeltaTable getNDLTable(AFND aflambda) {
        System.out.println("Lambda");
        NDLTable d = new NDLTable();
        d.addState(getStringClosure(aflambda.getStates()));
        d.addSymbols(aflambda.getInputAlphabet());
        for (State state : aflambda.getStates()) {
            for (String symbol : aflambda.getInputAlphabet()) {
                if (!symbol.equals(".")) {
                    List<String> l = state.getStringClosure(symbol);
                    d.addTransition(state.getName(), symbol, l);
                }
            }
        }

        for (State state : aflambda.getStates()) {
            d.addLambdaClosure(state.getName(), state.getLambdaClosure());
        }
        return d;
    }

    private static List<String> getStringClosure(List<State> states) {
        List<String> list = new ArrayList<String>();
        for (State state : states) {
            list.add(state.getName());
        }
        Collections.sort(list);
        return list;
    }

    public static DTable convertToAFD(NDTable tbin, List<String> iniciais) {

        DTable d = new DTable();
        d.addSymbols(tbin.getSymbols());
        //List<List<String>> states = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        List<String> aux = iniciais;
        d.addState(getEstado(aux));
        map.put(getEstado(aux), aux);
        ///
        /* String q = "q0";
        String a = "a";
        List<String> la = tbin.getClosure(q, a);
        System.out.println("(" + q + "-" + a + ") ->" + tbin.getClosure(q, a) + "    \t");*/
 /* for (String state : tbin.getStates()) {
            for (String symbol : tbin.getSymbols()) {
                List<String> l = tbin.getClosure(state, symbol);
                System.out.print("(" + state + "-" + symbol + ") ->" + tbin.getClosure(state, symbol) + "    \t");
            }
            System.out.println();
        }*/
        Table t = new Table();
        for (String state : tbin.getStates()) {
            for (String symbol : tbin.getSymbols()) {
                List<String> l = tbin.getClosure(state, symbol);
                Cell c = new Cell(symbol, state, l); //System.out.print("(" + state + "-" + symbol + ") ->" + tbin.getClosure(state, symbol) + "    \t");
                t.addCell(c);
            }
        }
        Table tabela = new Table();

        while (map.size() > 0) {
            for (String string : map.keySet()) {
                aux = map.get(string);
            }
            //for (String state : aux) {
            if (!d.getStates().contains(getEstado(aux))) {
                d.addState(getEstado(aux));
            }
            for (String symbol : tbin.getSymbols()) {
                //List<String> init = t.getList(state, symbol);
                List<String> state = getTransitionElement(t, aux, symbol);

                if (state != null && state.size() > 0) {
                    tabela.addCell(new Cell(symbol, getEstado(aux), state));
                    d.addTransition(getEstado(aux), symbol, getEstado(state));
                    //System.out.println(symbol+" - "+getEstado(init));
                    if (!d.getStates().contains(getEstado(state))) {
                        d.addState(getEstado(state));
                        map.put(getEstado(state), state);
                    }
                }
//                    if (init != null && init.size() > 0) {
//                        tabela.addCell(new Cell(symbol, getEstado(aux), init));
//                        d.addTransition(getEstado(aux), symbol, getEstado(init));
//                        //System.out.println(symbol+" - "+getEstado(init));
//                        if (!d.getStates().contains(getEstado(init))) {
//                            d.addState(getEstado(init));
//                        }
//                        map.put(getEstado(init), init);
//                    }
            }
            map.remove(getEstado(aux), aux);
            // }
        }
        d.setTable(tabela);

        return d;
    }

    private static List<String> getTransitionElement(Table tabela, List<String> states, String symbol) {
        Set<String> st = new TreeSet<String>();
        for (String state : states) {
            if (tabela != null) {
                List<String> l = tabela.getList(state, symbol);
                if (l != null) {
                    st.addAll(l);
                }
            }

        }

        return new ArrayList<>(st);
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
}
