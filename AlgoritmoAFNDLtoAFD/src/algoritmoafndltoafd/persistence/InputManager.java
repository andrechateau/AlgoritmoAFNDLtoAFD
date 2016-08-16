/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoafndltoafd.persistence;

import algoritmoafndltoafd.model.FiniteAutomaton;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Otavio
 */
public class InputManager {

    private String fileName;

    public InputManager(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Handle all lines from description file and turn into String
     *
     * @return The String with all file
     * @throws FileNotFoundException To informe the UI
     */
    private String loadString() throws FileNotFoundException {
        String linearArchive = "";
        try {
            BufferedReader buffRead = new BufferedReader(new FileReader(fileName));
            String temp;
            while ((temp = buffRead.readLine()) != null) {
                linearArchive += temp;
            }
            buffRead.close();
        } catch (IOException ex) {
            Logger.getLogger(InputManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return linearArchive;
    }

    /**
     * Handle the String of file to build a finite automaton
     *
     * @return Return the finiteAutomaton of given file
     * @throws FileNotFoundException To informe the UI
     */
    public FiniteAutomaton loadAutomaton() throws FileNotFoundException {
        FiniteAutomaton finiteAutomaton = new FiniteAutomaton();
        String linearArchive = loadString();
        int position = 0;

        return finiteAutomaton;
    }

    /**
     * Catch everything between two symbols and separete by commas
     *
     * @param linearArchive String that have the symbol
     * @param position atual position in linearArchive
     * @return ArrayList with the objects found between the symbols
     */
    public ArrayList<String> catchBetweenSymbol(String linearArchive, int position) {
        ArrayList<String> obj = new ArrayList<>();
        while (linearArchive.indexOf(")") != linearArchive.charAt(position) || linearArchive.indexOf("}") != linearArchive.charAt(position)) {
            if (linearArchive.charAt(position) == '(' || linearArchive.charAt(position) == '{') {
                
            }
        }
        return obj;
    }
}
