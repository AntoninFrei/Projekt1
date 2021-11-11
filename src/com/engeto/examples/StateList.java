package com.engeto.examples;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.*;

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

    public void exportToFile(int maxVAT) {
        String fileName = "vat-over-" + maxVAT + ".txt";
        try (PrintWriter writer = new PrintWriter(new File(fileName))) {
            writer.println(this.getOverValue(maxVAT));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public String getOverValue(int maxVAT) {

        List<State> StatesOver = new ArrayList<>();
        String otherState = "\nSazba VAT " + maxVAT + " % nebo nižší nebo používají speciální sazbu: ";
        String out = "";
        for (State item : States) {
            int res = item.fullVAT.compareTo(BigDecimal.valueOf(maxVAT));
            if (res > 0 && ! item.hasSpecialVAT) {
                StatesOver.add(item);
            }
            else {
                otherState += item.shortcut + ", ";
            }

        }

        Collections.sort(StatesOver, new StatesVATComparator());

        for (State item : StatesOver) out += item.getStateBothInfo() + "\n";



        return out + otherState;
    }

    public String getAllStatesBasicInfo() {
        String out = "";
        for (State item : States) out += item.getStateBasicInfo() + "\n";
        return out;
    }

}
