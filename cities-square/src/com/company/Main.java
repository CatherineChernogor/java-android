package com.company;


import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Mansion m = new Mansion(0.45, 15, 10, 3);
        System.out.println(m);
        Park p = new Park(0.75, 200, 300);
        System.out.println(p);
        Theatre t = new Theatre(0.7, 30, 5);
        System.out.println(t);

        ArrayList<Building> city = new ArrayList<Building>();
        city.add(m);
        city.add(p);
        city.add(t);

        System.out.println(city);
        Collections.sort(city);
        System.out.println(city);
        
    }
}
