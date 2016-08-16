/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoafndltoafd.model.interfaces;

/**
 * This interface stands for the Delta Deterministic Table on the Powerset
 * Conversion context. It's the final table of this conversion.
 *
 * @author Andre Chateaubriand
 */
public interface DeltaDTable extends DeltaTable {

    /**
     * This method is intented for the construction of the table. Within the
     * given state and symbol for the transition, it returns a state name which
     * this combination goes. Represents the state on the table's Cell, in which
     * the line is the one for the given state, and the column the one standing
     * for the symbol of transition.
     *
     * @param state The given state.
     * @param symbol The given transition.
     * @return a sate name of this cell.
     */
    public String getClosure(String state, String symbol);

}
