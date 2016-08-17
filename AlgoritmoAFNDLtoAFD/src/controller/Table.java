/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Andre Chateaubriand
 */
public class Table {

    List<Cell> cells;

    /*public Table(List<Cell> cells) {
        this.cells = cells;
    }*/
    public Table() {
        cells = new ArrayList<Cell>();
    }

    public List<String> getList(String state, String symbol) {
        for (Cell cell : cells) {
            if (cell.getSymbol().equals(symbol)) {
                if (cell.getState().equals(state)) {
                    return new ArrayList<>(cell.getClosure());
                }
            }
        }
        return null;
    }

    public void addCell(Cell entryCell) {
        boolean exists = false;
        for (Cell cell : cells) {
            if (cell.getSymbol().equals(entryCell.getSymbol()) && cell.getState().equals(entryCell.getState())) {
                cell.getClosure().addAll(entryCell.getClosure());
                exists = true;
            }
        }
        if (!exists) {
            cells.add(entryCell);
        }
    }
}
