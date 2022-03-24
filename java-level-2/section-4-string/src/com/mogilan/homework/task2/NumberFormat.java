package com.mogilan.homework.task2;

/*Написать программу, преобразующую строку, содержащую число в римском формате, в число в арабском формате.
Границы чисел: от 1 до 3999. Предусмотреть случай, когда меньший символ идёт перед большим:
Например CM == 900.

Соответствие:
M 1000
D 500
C 100
L 50
X 10
V 5
I 1
*/

import java.util.Scanner;

public class NumberFormat {
    public static void main(String[] args) {
        RomanNumber romanNumber = new RomanNumber();
        System.out.println(romanNumber.getValue());
        System.out.println(romanToArabic(romanNumber.getValue()));
    }

    public static int romanToArabic (String romanNumber) {
        int arabicNumber = 0;
        char [] romanChar = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int [] romanCharValue = {1, 5, 10, 50, 100, 500, 1000};
        for (int i = 0; i < romanNumber.length(); i++) {
            checkChar:
            {
                for (int j = 0; j < romanChar.length; j++) {
                    if (romanNumber.charAt(i) == romanChar[j]) {
                       if (i == romanNumber.length() - 1) arabicNumber += romanCharValue[j];
                       else {
                           for (int k = j + 1; k < romanChar.length; k++) {
                               if (romanNumber.charAt(i + 1) == romanChar[k]) {
                                   arabicNumber += (romanCharValue[k] - romanCharValue[j]);
                                   i++;
                                   break checkChar;
                               }
                           }
                           arabicNumber += romanCharValue[j];
                       }
                   }
               }
            }
        }
        return arabicNumber;
    }
}
