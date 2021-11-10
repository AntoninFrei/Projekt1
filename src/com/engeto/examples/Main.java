package com.engeto.examples;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        StateList listOfState = new StateList();

        try {
            listOfState.importFromFile("vat-eu.txt");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Základní výpis:");
        System.out.println(listOfState.getAllStatesBasicInfo());

        System.out.println(listOfState.getOverValue());


    }
}
