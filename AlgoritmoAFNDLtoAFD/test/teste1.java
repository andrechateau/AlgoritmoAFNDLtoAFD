
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

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
        HashMap<Integer, List<teste1>> map = new HashMap<>();
        //map.put(0, new teste1("Joao"));
        System.out.println(map.size());
        if (!map.containsKey(0)) {
            map.put(0, new LinkedList<teste1>());
        }
        map.get(0).add(new teste1("Joao"));
        map.get(0).add(new teste1("Maria"));

        System.out.println(map.get(0).size());
    }
}
