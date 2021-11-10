package com.engeto.examples;

import java.util.Comparator;

public class StatesVATComparator implements Comparator<State> {
    @Override
    public int compare(State first, State second) {

        return new Double(second.getFullVAT()).compareTo(new Double(first.getFullVAT()));

    }
}
