/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoafndltoafd.model;

import algoritmoafndltoafd.model.interfaces.DeltaTable;
import controller.TableController;
import java.util.ArrayList;

/**
 *
 * @author Otavio
 */
public class AFND extends FiniteAutomaton {

    private ArrayList<AFNDTransition> transitions;

    public AFND() {
        transitions = new ArrayList<>();
    }

    /**
     * Add a transition to the list of transitions
     *
     * @param transition
     */
    public void addTransition(AFNDTransition transition) {
        transitions.add(transition);
    }

    public void generateTable(Type type) {
        System.out.print("generating...");
        if (type == Type.TYPE_NONDETERMINISTIC) {
            setTable(TableController.getNDTable(this));
        }
        if (type == Type.TYPE_LAMBDATRANSITION) {
            DeltaTable dt = TableController.getNDLTable(this);
            setTable(dt);
        }

    }

    @Override
    public DeltaTable getTable() {
        if (super.getTable() != null) {
            return super.getTable();
        } else {
            throw new RuntimeException("Gere a tabela antes mano, na moral.");
        }
    }

    public enum Type {
        TYPE_NONDETERMINISTIC, TYPE_LAMBDATRANSITION;
    }
}
