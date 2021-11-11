package com.engeto.examples;

import java.math.BigDecimal;
import java.util.Scanner;

public class ReadInput {

    private static Scanner scanner = null;
    private static Scanner getScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

    public static BigDecimal INVALID_INPUT = BigDecimal.valueOf(-1);

    /**
     * Read one integer. If given input cannot be converted to integer,
     * prints error and return -1;
     * @return Integer read or -1 if invalid input entered
     */
    public static BigDecimal safeReadInt(String implicit) throws StateException {
        BigDecimal result = INVALID_INPUT;
        String inputText = getScanner().nextLine();

        if (inputText.length() == 0) {
            inputText = implicit;
        }

        try {
            result = new BigDecimal(inputText);
            if (result.compareTo(BigDecimal.valueOf(0)) < 0) {
                throw new StateException("Zadal jsi záporné číslo: "+inputText
                        + ". Hodnota VAT musí být kladné číslo!");
            }
        }  catch (NumberFormatException e) {
            throw new StateException("Zadal jsi text, který nelze převést na číslo: "+inputText);
        }

        return result;
    }

}
