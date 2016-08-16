/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoafndltoafd.persistence;

import algoritmoafndltoafd.model.FiniteAutomaton;
import algoritmoafndltoafd.model.FiniteAutomatonNotDeterministic;
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
    private int position;
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
    public FiniteAutomatonNotDeterministic loadAutomaton() throws FileNotFoundException {
        FiniteAutomatonNotDeterministic finiteAutomaton = new FiniteAutomatonNotDeterministic();
        String linearArchive = loadString();
        position = 0;
        
        return finiteAutomaton;
    }

    /**
     * Catch everything between two symbols and separeted by commas
     *
     * @param linearArchive String that have the symbol
     * @return ArrayList with the objects found between the symbols
     */
    public ArrayList<String> catchBetweenSymbol(String linearArchive) {
        ArrayList<String> obj = new ArrayList<>();
        while (linearArchive.indexOf(")") != linearArchive.charAt(position) || linearArchive.indexOf("}") != linearArchive.charAt(position)) {
            if (linearArchive.charAt(position) == '(' || linearArchive.charAt(position) == '{') {
                
            }
        }
        return obj;
    }
}
