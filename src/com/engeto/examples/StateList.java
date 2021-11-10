package com.engeto.examples;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StateList {
    private List<State> States = new ArrayList<>();

    public void add(State state) {States.add(state);}

    public void importFromFile(String fileName) throws FileNotFoundException {
        // Vymaže dosavadní položky:
        States.clear();
        // Načte ze souboru nové položky:
        try (Scanner scanner = new Scanner(new File(fileName))) {
            int lineNumber = 0;
            while (scanner.hasNextLine()) {
                lineNumber++;
                String nextLine = scanner.nextLine();
                String[] items = nextLine.split("\t");
                States.add(new State(items[0], items[1], items[2],
                        items[3], items[4]));
            }
        }
    }




    public String getAllStatesBasicInfo() {
        String out = "";
        for (State item : States) out += item.getStateBasicInfo();
        return out;
    }
}
