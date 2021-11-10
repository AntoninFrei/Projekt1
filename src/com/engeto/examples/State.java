package com.engeto.examples;

public class State {
    String shortcut;
    String name;
    double fullVAT;
    double lowerVAT;
    boolean hasSpecialVAT;

    public State(String shortcut, String name, String fullVAT, String lowerVAT, String hasSpecialVAT)  {

    }

    public State(String shortcut, String name, double fullVAT, double lowerVAT, Boolean hasSpecialVAT)  {
        this.shortcut = shortcut;
        this.name = name;
        this.fullVAT = fullVAT;
        this.lowerVAT = lowerVAT;
        this.hasSpecialVAT = hasSpecialVAT;

    }
}
