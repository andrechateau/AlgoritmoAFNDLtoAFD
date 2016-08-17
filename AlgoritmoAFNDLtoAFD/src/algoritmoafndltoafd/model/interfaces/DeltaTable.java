/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoafndltoafd.model.interfaces;

import java.util.List;

/**
 * This interface stands for the generic calls of every table in the Powerset
 * Conversion context
 *
 * @author Andre Chateaubriand
 */
    public interface DeltaTable {

    /**
     *
     * @return a list of all state names of the table.
     */
    public List<String> getStates();

    /**
     *
     * @return a list of all the symbol of the table header.
     */
    public List<String> getSymbols();
}
