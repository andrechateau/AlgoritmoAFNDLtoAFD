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
public class AFD extends FiniteAutomaton {

    private ArrayList<AFNDTransition> transitions;

    /**
     * Add a transition to the list of transitions
     *
     * @param transition
     */
    public void addTransition(AFNDTransition transition) {
        transitions.add(transition);
    }

    @Override
    public DeltaTable getTable() {
        if (super.getTable() == null) {
            setTable(TableController.getDTable(this));
        }
        return super.getTable();
    }
}
