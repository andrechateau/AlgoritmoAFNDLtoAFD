/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Andre Chateaubriand
 */
public class KeyPair {

    private String state;
    private String symbol;

    public KeyPair() {
    }

    public KeyPair(String state, String symbol) {
        this.state = state;
        this.symbol = symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof KeyPair)) {
            return false;
        }
        KeyPair key = (KeyPair) o;
        return state == key.state && symbol == key.symbol;
    }

    @Override
    public int hashCode() {
        int result = state.hashCode();
        result = 31 * result + symbol.hashCode();
        return result;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * @param symbol the symbol to set
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
