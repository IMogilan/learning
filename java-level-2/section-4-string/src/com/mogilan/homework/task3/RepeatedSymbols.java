package com.mogilan.homework.task3;

/*Дана строка.
Удалить из нее все повторяющиеся символы без учета регистра, если они идут друг за другом.
Также удалить пробелы.
Результат привести к верхнему регистру.
Например:
“abc Cpddd Dio OsfWw” -> “ABCPDIOSFW”*/

public class RepeatedSymbols {

    public static void main(String[] args) {
        String line = "abc Cpddd Dio OsfWw";
        System.out.println(deleteRepeatedValuesAndSpaces(line));

    }

    public static String deleteRepeatedValuesAndSpaces (String line) {
        String lineUpperCase = line.trim().toUpperCase().replace(" ", "");
        System.out.println(lineUpperCase);
        StringBuilder finalLine = new StringBuilder().append(lineUpperCase.charAt(0));
        for (int i = 1; i < lineUpperCase.length(); i++) {
            if (lineUpperCase.charAt(i) == lineUpperCase.charAt(i - 1)) continue;
            finalLine.append(lineUpperCase.charAt(i));
        }
        return finalLine.toString();
    }
}
