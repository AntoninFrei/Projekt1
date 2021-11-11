package com.engeto.examples;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;
import java.util.Comparator;

public class State {
    String shortcut;
    String name;
    BigDecimal fullVAT;
    BigDecimal lowerVAT;
    boolean hasSpecialVAT;

    public State(String shortcut, String name, String fullVAT, String lowerVAT, String hasSpecialVAT)
            throws StateException {
        this.shortcut = shortcut;
        this.name = name;
        try {
            this.fullVAT = new BigDecimal(fullVAT.replace(",", "."));
        } catch (NumberFormatException e) {
            throw new StateException(setMesssage(fullVAT, name));
        }
        try {
            this.lowerVAT = new BigDecimal(lowerVAT.replace(",", "."));
        } catch (NumberFormatException e) {
            throw new StateException(setMesssage(lowerVAT, name));
        }
        hasSpecialVAT = hasSpecialVAT.toLowerCase();
        if (hasSpecialVAT.equals("false") || hasSpecialVAT.equals("true")) {



            this.hasSpecialVAT = Boolean.parseBoolean(hasSpecialVAT);
            System.out.println(hasSpecialVAT +"/"+this.hasSpecialVAT);
        }
        else {
            throw new StateException(setMesssage(hasSpecialVAT, name));
        }


    }


    public State(String shortcut, String name, BigDecimal fullVAT, BigDecimal lowerVAT, Boolean hasSpecialVAT)  {
        this.shortcut = shortcut;
        this.name = name;
        this.fullVAT = fullVAT;
        this.lowerVAT = lowerVAT;
        this.hasSpecialVAT = hasSpecialVAT;

    }

    static String setMesssage(String Value, String State) {
        return "Zjištěna chyba na řádku pro stát: " + State +". Špatný formát hodnoty: \"" + Value + "\"!";
    }

    public String getStateBasicInfo() {
        return this.name + " (" + this.shortcut + "): " + this.fullVAT + " %";
    }

    public String getStateBothInfo() {
        return getStateBasicInfo() + " (" + this.lowerVAT + " %)";
    }

    public String getShortcut() {
        return shortcut;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getFullVAT() {
        return fullVAT;
    }


    public BigDecimal getLowerVAT() {
        return lowerVAT;
    }

    public boolean isHasSpecialVAT() {
        return hasSpecialVAT;
    }
}
