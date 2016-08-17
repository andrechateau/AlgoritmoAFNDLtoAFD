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
import algoritmoafndltoafd.model.interfaces.DeltaDTable;
import algoritmoafndltoafd.model.interfaces.DeltaNDLTable;
import algoritmoafndltoafd.model.interfaces.DeltaNDTable;
import java.io.PrintWriter;
import java.util.List;

public class OutputManager {
    static String answer = "";
    String file = "";
    public OutputManager(String txt){
        this.file = txt;
    }
    public void saveAFNDLambda(DeltaNDLTable table){
        List<String> symbols = table.getSymbols();
        List<String> states = table.getStates();
        String r = "";
        r += "==============================================\n";
        System.out.print("AFND-L\n");
        int closureSize = 0;
        for (String state : states) {
            for (String symbol : symbols) {
                if(table.getClosure(state, symbol)!=null){
                    if(table.getClosure(state, symbol).size() > closureSize){
                        closureSize = table.getClosure(state, symbol).toString().length();
                    }
                }
            }
        }
        closureSize += 5;
        r+="\t";
        for (String symbol : symbols) {
            r += String.format("%s %"+(closureSize-1)+"s",symbol,"");
        }
        r += "lambda\n";
        int closureMin = 0;
        /// LINHA
        for (String state : states) {
            r += state + "\t";
            for (String symbol : symbols) {
                if(table.getClosure(state, symbol)!=null){
                    closureMin = table.getClosure(state, symbol).toString().length();
                }else{
                    closureMin = 0;
                }
                r += String.format("%s %"+(closureSize-closureMin)+"s",getConjunto(table.getClosure(state, symbol)),"");
            }
            r += getConjunto(table.getLClosure(state));
            r += "\n";
        }
        r += "==============================================\n";

        System.out.print(r);
        answer += r;
    }
    public void saveAFND(DeltaNDTable table){
        List<String> symbols = table.getSymbols();
        List<String> states = table.getStates();
        String r = "";
        r += "==============================================\n";
        System.out.print("AFND\n");
        int closureSize = 0;
        for (String state : states) {
            for (String symbol : symbols) {
                if(table.getClosure(state, symbol)!=null){
                    if(table.getClosure(state, symbol).toString().length() > closureSize){
                        closureSize = table.getClosure(state, symbol).toString().length();
                    }
                }
            }
        }
        closureSize += 5;
        r+="\t";
        for (String symbol : symbols) {
            r += String.format("%s %"+(closureSize-1)+"s",symbol,"");
        }
        int closureMin = 0;
        /// LINHA
        r+="\n";
        for (String state : states) {
            r += state + "\t";
            for (String symbol : symbols) {
                if(table.getClosure(state, symbol)!=null){
                    closureMin = table.getClosure(state, symbol).toString().length();
                }else{
                    closureMin = 0;
                }
                r += String.format("%s %"+(closureSize-closureMin)+"s",getConjunto(table.getClosure(state, symbol)),"");
            }
            r += "\n";
        }
        r += "==============================================\n";

        System.out.print(r);
        answer += r;
    }
    
    public void saveAFD(DeltaDTable table){
        List<String> symbols = table.getSymbols();
        List<String> states = table.getStates();
        String r = "";
        r += "==============================================\n";
        System.out.print("AFD\n");
        int closureSize = 0;
        for (String state : states) {
            for (String symbol : symbols) {
                if(table.getClosure(state, symbol)!=null){
                    if(table.getClosure(state, symbol).length() > closureSize){
                        closureSize = table.getClosure(state, symbol).length();
                    }
                }
            }
        }
        closureSize += 5;
        r+="\t";
        for (String symbol : symbols) {
            r += String.format("%s %"+(closureSize-1)+"s",symbol,"");
        }
        int closureMin = 0;
        /// LINHA
        r+="\n";
        for (String state : states) {
            r += state + "\t";
            for (String symbol : symbols) {
                if(table.getClosure(state, symbol)!=null){
                    closureMin = table.getClosure(state, symbol).toString().length();
                }else{
                    closureMin = 0;
                }
                r += String.format("%s %"+(closureSize-closureMin)+"s",table.getClosure(state, symbol),"");
            }
            r += "\n";
        }
        r += "==============================================\n";

        System.out.print(r);
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
    public void saveFile(){
        try{
            PrintWriter out = new PrintWriter(this.file,"UTF-8");
            out.println(answer);
            out.close();
        }
        catch(Exception ex){
            
        }
        
    }
}
