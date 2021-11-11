package com.engeto.examples;

import java.io.FileNotFoundException;

import static com.engeto.examples.ReadInput.safeReadInt;

public class Main {

    public static void main(String[] args) {
        String implicit = "20";
        int maxVAT = -1;
        while (maxVAT < 0) {
            System.out.println("Zadej hodnotu daně která tě zajímá, nebo klávesou \"Enter\" potvrď výchozí hodnotu "
                    + implicit + " %.");
            try {
                maxVAT = safeReadInt(implicit);
            } catch (StateException e) {
                e.printStackTrace();
            }
        }


        StateList listOfState = new StateList();

        try {
            listOfState.importFromFile("vat-eu.txt");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Základní výpis:");
        System.out.println(listOfState.getAllStatesBasicInfo());

        //System.out.println(listOfState.getOverValue(maxVAT));

        listOfState.exportToFile(maxVAT);


    }
}
