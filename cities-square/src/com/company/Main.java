package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        Park p = new Park(0.75, 200, 300);
        //System.out.println(p);
        Theatre t = new Theatre(0.7, 30, 5);
        //System.out.println(t);
        Mansion m = new Mansion(0.45, 15, 10, 3);
        //System.out.println(m);

        if (m.getArea() > t.getArea())
            System.out.println("Mansion is bigger than Park");
        else if (m.getArea() < t.getArea())
            System.out.println("Park is bigger than Mansion");
        else
            System.out.println("Mansion and Park have equal price");

        ArrayList<Building> city = new ArrayList<Building>();
        city.add(p);
        city.add(t);
        city.add(m);

        System.out.println('\n');
        System.out.println(city);
        System.out.println('\n');
        Collections.sort(city);
        System.out.println(city);

    }
}
