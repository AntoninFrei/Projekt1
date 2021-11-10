package com.engeto.examples;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        StateList listOfState = new StateList();
        //State Cz = new State("CZ", "Czech", 21, 15, true);
        //listOfState.add(Cz);
        try {
            listOfState.importFromFile("vat-eu.txt");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(listOfState.getAllStatesBasicInfo());
        System.out.println("xxx");
    }
}
