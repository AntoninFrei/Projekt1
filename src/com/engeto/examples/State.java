package com.engeto.examples;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class State {
    String shortcut;
    String name;
    double fullVAT;
    double lowerVAT;
    boolean hasSpecialVAT;

    public State(String shortcut, String name, String fullVAT, String lowerVAT, String hasSpecialVAT)  {
        this.shortcut = shortcut;
        this.name = name;
        this.fullVAT = Double.parseDouble(fullVAT.replace(",","."));
        this.lowerVAT = Double.parseDouble(lowerVAT.replace(",","."));
        this.hasSpecialVAT = Boolean.parseBoolean(hasSpecialVAT);

    }

    public State(String shortcut, String name, double fullVAT, double lowerVAT, Boolean hasSpecialVAT)  {
        this.shortcut = shortcut;
        this.name = name;
        this.fullVAT = fullVAT;
        this.lowerVAT = lowerVAT;
        this.hasSpecialVAT = hasSpecialVAT;

    }

    public String getStateBasicInfo() {
        return this.name + " (" + this.shortcut + "): " + this.fullVAT + " %\n";
    }


}
