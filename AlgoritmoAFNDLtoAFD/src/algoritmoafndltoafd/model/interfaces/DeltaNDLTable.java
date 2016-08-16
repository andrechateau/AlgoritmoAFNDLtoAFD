/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoafndltoafd.model.interfaces;

import java.util.List;

/**
 * This interface stands for the Delta Non Deterministic with Lamda Transition
 * Table on the Powerset Conversion context. It's the first table of this
 * conversion.
 *
 * @author Andre Chateaubriand
 */
public interface DeltaNDLTable extends DeltaNDTable {

    /**
     * This method is intented for the construction of the table. Within the
     * given state, it returns a list of all states which you can go without
     * consumpting symbols, only lambda. Returns the Lambda Closure (aka.
     * Epsilon Closure).
     *
     * @param state The given state.
     * @return a list containing the set of sates names of the Closure.
     */
    public List<String> getLClosure(String state);

}
