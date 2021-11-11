package com.engeto.examples;

import java.util.Scanner;

public class ReadInput {

    private static Scanner scanner = null;
    private static Scanner getScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

    public static int INVALID_INPUT = -1;

    /**
     * Read one integer. If given input cannot be converted to integer,
     * prints error and return -1;
     * @return Integer read or -1 if invalid input entered
     */
    public static int safeReadInt(String implicit) throws StateException {
        int result = INVALID_INPUT;
        String inputText = getScanner().nextLine();

        if (inputText.length() == 0) {
            inputText = implicit;
        }

        try {
            result = Integer.parseInt(inputText);
            if (result < 0) {
                throw new StateException("Zadal jsi záporné číslo: "+inputText
                        + ". Hodnota VAT musí být kladné číslo!");
            }
        }  catch (NumberFormatException e) {
            throw new StateException("Zadal jsi text, který nelze převést na celé číslo: "+inputText);
        }

        return result;
    }

}
