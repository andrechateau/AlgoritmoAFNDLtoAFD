/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoafndltoafd;

import algoritmoafndltoafd.model.AFND;
import algoritmoafndltoafd.persistence.InputManager;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andre Chateaubriand
 */
public class AlgoritmoAFNDLtoAFD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InputManager im = new InputManager("entrada.txt");
        try {
            AFND auto = im.loadAutomaton();
            auto.generateTable(AFND.Type.TYPE_LAMBDATRANSITION);
            System.out.println(auto.getTable());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AlgoritmoAFNDLtoAFD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
