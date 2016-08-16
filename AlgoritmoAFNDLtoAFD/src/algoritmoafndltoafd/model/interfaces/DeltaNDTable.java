/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoafndltoafd.model.interfaces;

import java.util.List;

/**
 * This interface stands for the Delta Non Deterministic Table on the Powerset
 * Conversion context. It's the second table of this conversion when there's the
 * Non-Determinist with lambda transition, or the first if there's not.
 *
 * @author Andre Chateaubriand
 */
public interface DeltaNDTable extends DeltaTable {

    /**
     * This method is intented for the construction of the table. Within the
     * given state and symbol for the transition, it returns a list of all
     * states which this combination goes. Represents the Set on the table's
     * Cell, in which the line is the one for the given state, and the column
     * the one standing for the symbol of transition.
     *
     * @param state The given state.
     * @param symbol The given transition.
     * @return a list containing the set of sates names of this cell.
     */
    public List<String> getClosure(String state, String symbol);
}
