/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoafndltoafd;

import algoritmoafndltoafd.model.AFND;
import algoritmoafndltoafd.persistence.InputManager;
import algoritmoafndltoafd.persistence.OutputManager;
import controller.DTable;
import controller.NDLTable;
import controller.NDTable;
import controller.TableController;
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
        //InputManager im = new InputManager("entrada.txt");
        InputManager im;
        OutputManager om;
        if (args.length < 2) {
            im = new InputManager("descricao.txt");
            om = new OutputManager("saida.txt");
        } else {
            im = new InputManager(args[0]);
            om = new OutputManager(args[1]);
        }
        try {
            AFND auto = im.loadAutomaton();
            auto.generateTable(AFND.Type.TYPE_LAMBDATRANSITION);
            om.saveAFNDLambda((NDLTable) auto.getTable());
            System.out.println(auto.getTable());

            /////
            NDTable tb = TableController.removeL((NDLTable) auto.getTable());
            om.saveAFND(tb);
            System.out.println(tb);
            ///
            DTable d = TableController.convertToAFD(tb, ((NDLTable) auto.getTable()).getLClosure(auto.getStartState().getName()));
            om.saveAFD(d);
            System.out.println(d);
            om.saveFile();
            //tb.addState(auto.getStates());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(AlgoritmoAFNDLtoAFD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
