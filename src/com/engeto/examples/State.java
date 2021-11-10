package com.engeto.examples;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Comparator;

public class State {
    String shortcut;
    String name;
    Double fullVAT;
    Double lowerVAT;
    boolean hasSpecialVAT;

    public State(String shortcut, String name, String fullVAT, String lowerVAT, String hasSpecialVAT)  {
        this.shortcut = shortcut;
        this.name = name;
        this.fullVAT = Double.parseDouble(fullVAT.replace(",","."));
        this.lowerVAT = Double.parseDouble(lowerVAT.replace(",","."));
        this.hasSpecialVAT = Boolean.parseBoolean(hasSpecialVAT);

    }

    public State(String shortcut, String name, Double fullVAT, Double lowerVAT, Boolean hasSpecialVAT)  {
        this.shortcut = shortcut;
        this.name = name;
        this.fullVAT = fullVAT;
        this.lowerVAT = lowerVAT;
        this.hasSpecialVAT = hasSpecialVAT;

    }

    public String getStateBasicInfo() {
        return this.name + " (" + this.shortcut + "): " + this.fullVAT + " %\n";
    }

    public String getShortcut() {
        return shortcut;
    }

    public String getName() {
        return name;
    }

    public double getFullVAT() {
        return fullVAT;
    }

    public double getLowerVAT() {
        return lowerVAT;
    }

    public boolean isHasSpecialVAT() {
        return hasSpecialVAT;
    }
}
