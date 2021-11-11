package com.engeto.examples;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Comparator;

public class State {
    String shortcut;
    String name;
    BigDecimal fullVAT;
    BigDecimal lowerVAT;
    boolean hasSpecialVAT;

    public State(String shortcut, String name, String fullVAT, String lowerVAT, String hasSpecialVAT)  {
        this.shortcut = shortcut;
        this.name = name;
        this.fullVAT = new BigDecimal(fullVAT.replace(",","."));
        this.lowerVAT = new BigDecimal(lowerVAT.replace(",","."));
        this.hasSpecialVAT = Boolean.parseBoolean(hasSpecialVAT);

    }

    public State(String shortcut, String name, BigDecimal fullVAT, BigDecimal lowerVAT, Boolean hasSpecialVAT)  {
        this.shortcut = shortcut;
        this.name = name;
        this.fullVAT = fullVAT;
        this.lowerVAT = lowerVAT;
        this.hasSpecialVAT = hasSpecialVAT;

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
