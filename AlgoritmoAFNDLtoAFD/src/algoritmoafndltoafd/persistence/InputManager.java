/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoafndltoafd.persistence;

import algoritmoafndltoafd.model.AFND;
import algoritmoafndltoafd.model.AFNDTransition;
import algoritmoafndltoafd.model.State;
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
    private String loadStringFromFile() throws FileNotFoundException {
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
    public AFND loadAutomaton() throws FileNotFoundException {
        String linearFile = loadStringFromFile();
        AFND automatonFinite = new AFND();
        position = 1;

        System.out.println(linearFile);
        ArrayList<String> statesString = catchBetweenSymbol(linearFile, "}");
        for (String stateString : statesString) {
            automatonFinite.addState(new State(stateString, false, false));
        }
        position += 2;
        ArrayList<String> alphaString = catchBetweenSymbol(linearFile, "}");
        for (String aplha : alphaString) {
            automatonFinite.addSymbol(aplha);
        }
        position += 3;
        catchAllTransition(linearFile, automatonFinite);
        position += 2;
        String startStateString = linearFile.substring(position, linearFile.indexOf(",", position));
        position = linearFile.indexOf(",", position);
        automatonFinite.changeStartState(startStateString, true);
        position += 1;
        ArrayList<String> finalStatesString = catchBetweenSymbol(linearFile, "}");
        for (String finalStateString : finalStatesString) {
            automatonFinite.changeFinalState(finalStateString, true);
        }
        for (State state : automatonFinite.getStates()) {
            System.out.println(state);
        }
        for(String alph : automatonFinite.getInputAlphabet()){
            System.out.println(alph);
        }
        return automatonFinite;
    }

    /**
     * Catch everything between two symbols and separeted by commas
     *
     * @param linearFile String that have the symbol
     * @param symbol
     * @return ArrayList with the objects found between the symbols
     */
    public ArrayList<String> catchBetweenSymbol(String linearFile, String symbol) {
        ArrayList<String> obj = new ArrayList<>();
        while (linearFile.indexOf(symbol, position) != position) {
            position++;

            if (linearFile.indexOf(",", position) >= 0 && linearFile.indexOf(",", position) < linearFile.indexOf(symbol, position)) {
                obj.add(linearFile.substring(position, linearFile.indexOf(",", position)));
                position = linearFile.indexOf(",", position);
            } else {
                obj.add(linearFile.substring(position, linearFile.indexOf(symbol, position)));
                position = linearFile.indexOf(symbol, position);
            }

        }
        return obj;
    }

    /**
     *
     * @param linearFile
     * @param automatonFinite
     */
    public void catchAllTransition(String linearFile, AFND automatonFinite) {
        while (linearFile.indexOf("}", position) != position) {
            AFNDTransition transition = new AFNDTransition();
            ArrayList<String> origens = catchBetweenSymbol(linearFile, ")");
            position += 3;
            ArrayList<String> destinos = catchBetweenSymbol(linearFile, "}");

            for (String destino : destinos) {
                transition.addTargetState(automatonFinite.getState(destino));
            }
            transition.setOriginState(automatonFinite.getState(origens.get(0)));
            automatonFinite.getState(origens.get(0)).addTransition(transition);
            transition.setSybol(origens.get(1));
            automatonFinite.addTransition(transition);

            if (linearFile.charAt(position + 2) == '(') {
                position += 2;
            } else if (linearFile.charAt(position + 1) == '}') {
                position += 1;
            }
        }
    }
}
