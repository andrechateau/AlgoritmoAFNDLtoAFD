/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoafndltoafd.persistence;

/**
 *
 * @author Roberto Gonçalves
 */
import algoritmoafndltoafd.AlgoritmoAFNDLtoAFD;
import algoritmoafndltoafd.model.interfaces.DeltaDTable;
import algoritmoafndltoafd.model.interfaces.DeltaNDLTable;
import algoritmoafndltoafd.model.interfaces.DeltaNDTable;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OutputManager {

    static String answer = "";
    String file = "";

    public OutputManager(String txt) {
        this.file = txt;
    }

    public void saveAFNDLambda(DeltaNDLTable table) {
        List<String> symbols = table.getSymbols();
        List<String> states = table.getStates();
        String r = "";
        r += "==========================================================================================" + System.lineSeparator();
        ///HEAD
        r += "\t";
        for (String symbol : symbols) {
            r += String.format("%-25s", symbol);
        }

        // r += String.format("%s", "lambda\n");
        r += String.format("%-25s", "lambda");
        //r += String.format("%s", "fecho-L\n");
        r += String.format("%s", "fecho-L" + System.lineSeparator());
        //r += System.lineSeparator();
        /// LINHA
        for (String state : states) {
            r += state + "\t";
            for (String symbol : symbols) {
                r += String.format("%-18s", getConjunto(table.getClosure(state, symbol))) + "\t";
                //r += (getClosure(state, symbol)!=null ? getClosure(state, symbol).toString() : "") + "\t";
            }
            //r += getConjunto(table.getLClosure(state));
            r += String.format("%-18s", getConjunto(table.getClosure(state, ".")));
            r += String.format("%-18s", getConjunto(table.getLClosure(state)));
            // r += "\n"
            r += System.lineSeparator();
        }
        r += "==========================================================================================" + System.lineSeparator();

        //System.out.print(r);
        answer += r;

    }

    public void saveAFND(DeltaNDTable table) {
        List<String> symbols = table.getSymbols();
        List<String> states = table.getStates();
        String r = "";
        r += "==========================================================================================" + System.lineSeparator();
        ///HEAD
        r += "\t";
        for (String symbol : symbols) {
            r += String.format("%-25s", symbol);
        }
        //r += String.format("%s", "\n");
        r += String.format("%s", System.lineSeparator());
        /// LINHA
        for (String state : states) {
            r += state + "\t";
            for (String symbol : symbols) {
                r += String.format("%-18s", getConjunto(table.getClosure(state, symbol))) + "\t";
                //r += (getClosure(state, symbol)!=null ? getClosure(state, symbol).toString() : "") + "\t";
            }
            r += System.lineSeparator();
            //r += "\n";
        }
        r += "==========================================================================================" + System.lineSeparator();

        //System.out.print(r);
        answer += r;
    }

    public void saveAFD(DeltaDTable table) {
        List<String> symbols = table.getSymbols();
        List<String> states = table.getStates();
        String r = "";
        r += "==========================================================================================" + System.lineSeparator();;
        ///HEAD
        r += "\t";
        r += String.format("%-18s", "");
        for (String symbol : symbols) {
            r += String.format("%-25s", symbol);
        }
        //r += String.format("%s", "\n");
        r += String.format("%s", System.lineSeparator());
        /// LINHA
        for (String state : states) {
            r += String.format("%-18s", state) + "\t";
            for (String symbol : symbols) {
                //r += String.format("%-18s", getClosure(state, symbol)) + "\t";
                /* if (table != null) {
                    r += String.format("%-18s", getEstado(table.getList(state, symbol))) + "\t";
                }*/
                r += String.format("%-18s", table.getClosure(state, symbol)) + "\t";

                //r += (getClosure(state, symbol)!=null ? getClosure(state, symbol).toString() : "") + "\t";
            }
            //r += "\n";
            r += System.lineSeparator();
        }
        r += "==========================================================================================\n";

        //System.out.print(r);
        answer += r;
    }

    private String getConjunto(List<String> strings) {

        String r = "{";
        if (strings != null) {
            for (String string : strings) {
                r += string + ",";
            }
            if (strings.size() >= 1) {
                r = r.substring(0, r.length() - 1);
            }

        }
        r += "}";
        return r;
    }

    public void saveFile() {
        try {
            try (PrintWriter out = new PrintWriter(this.file, "UTF-8")) {
                out.println(answer);
            }
        } catch (Exception ex) {
            Logger.getLogger("Não foi possível gerar o arquivo: " + ex);
        }

    }
}
