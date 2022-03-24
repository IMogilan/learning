package com.mogilan.homework.task2;

import java.util.Scanner;

public class RomanNumber {

    String value;

    public RomanNumber () {
        this.value = setNumber();
    }

    public RomanNumber (String value) {
        String currentValue = value;
        if (isRomanNumber(currentValue)) this.value = value;
        else this.value = setNumber();
    }

    public String getValue() {
        return value;
    }

    public final boolean isRomanNumber (String value) {
        char [] romanChars = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        for (int i = 0; i < value.length(); i++) {
            boolean isCorrectChar = false;
            for (int j = 0; j < romanChars.length; j++) {
                if (value.charAt(i) == romanChars[j]) {
                    isCorrectChar = true;
                    break;
                }
            }
            if (!isCorrectChar) {
                System.out.println("The number is not roman! Try again.");
                return false;}
        }
        return true;
    }

    private final String setNumber() {
        boolean isCorrectValue = true;
        String currentValue;
        Scanner scanner = new Scanner(System.in);
        setValue: {
            while (true) {
                do {
                    System.out.print("Enter the number (the value should be less than 3999 (MMMCMXCIX)): ");
                    if (!scanner.hasNext()) {
                        System.out.println("Incorrect value! Try again.");
                        isCorrectValue = false;
                    }
                } while (!isCorrectValue);
                currentValue = scanner.next();
                if (NumberFormat.romanToArabic(currentValue) > 3999) System.out.println("The value is above 3999. Please enter the value less than 3999 (MMMCMXCIX)");
                if ((isRomanNumber(currentValue)) && (NumberFormat.romanToArabic(currentValue) <= 3999)) break setValue;
            }
        }
        return currentValue;
    }

}
