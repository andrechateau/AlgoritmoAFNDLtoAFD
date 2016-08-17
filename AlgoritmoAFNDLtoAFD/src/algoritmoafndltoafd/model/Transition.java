/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoafndltoafd.model;

import java.util.ArrayList;

/**
 *
 * @author Otavio
 */
public class Transition {
    private State originState;
    private String symbol;

    /**
     * @return the originState
     */
    public State getOriginState() {
        return originState;
    }

    /**
     * @return the symbol
     */
    public String getSymbol() {
        return symbol;
    }
}
