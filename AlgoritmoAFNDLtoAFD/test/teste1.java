
import algoritmoafndltoafd.model.AFDTransition;
import algoritmoafndltoafd.model.AFNDTransition;
import algoritmoafndltoafd.model.State;
import algoritmoafndltoafd.model.Transition;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Andre Chateaubriand
 */
public class teste1 {

    private String i;

    public teste1(String i) {
        this.i = i;
    }

    public String getI() {
        return i;
    }

    public void setI(String i) {
        this.i = i;
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<String>();
        strings.add("q3");
        strings.add("q2");
        strings.add("q4");
        strings.add("q1");
        strings.add("q6");
        strings.add("q0");

        List<String> list = new ArrayList<String>();
        for (String string : strings) {
            list.add(string);
        }
        Collections.sort(list);
        for (String string : list) {
            System.out.println(string);
        }
    }
}
