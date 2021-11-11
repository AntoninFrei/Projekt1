package com.engeto.examples;

import java.math.BigDecimal;
import java.util.Comparator;

public class StatesVATComparator implements Comparator<State> {
    @Override
    public int compare(State first, State second) {
        int res = second.getFullVAT().compareTo(first.getFullVAT());

        return res;

    }
}
