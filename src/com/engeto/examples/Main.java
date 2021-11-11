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
        String inputFile = "vat-eu.txt";
        try {
            listOfState.importFromFile(inputFile);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (StateException e) {
            System.out.println("Chyba při čtení souboru: " + inputFile + ".\n");
            e.printStackTrace();
            System.out.println("Při této chybě musí být aplikace ukončena!\n");
            System.exit(0);
        }
        System.out.println("Základní výpis:");
        System.out.println(listOfState.getAllStatesBasicInfo());

        System.out.println(listOfState.getOverValue(maxVAT));

        try {
            listOfState.exportToFile(maxVAT);
        }
        catch (StateException e) {
            e.printStackTrace();
        }


    }
}
