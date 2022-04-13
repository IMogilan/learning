package com.mogilan.homework.task3;

/*Дана строка.
Удалить из нее все повторяющиеся символы без учета регистра, если они идут друг за другом.
Также удалить пробелы.
Результат привести к верхнему регистру.
Например:
“abc Cpddd Dio OsfWw” -> “ABCPDIOSFW”


Самостоятельное доп. задание: реализовать метод, которые удалял бы все пробелы и Все повторяющиеся символы (не только идущие друг за другом)*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RepeatedSymbols {

    public static void main(String[] args) {
        String line = "abc Cpddd Dio OsfWw";
        System.out.println(deleteRepeatedValuesAndSpaces(line));
        System.out.println(deleteAllRepeatedValuesAndSpaces(line));

    }

    public static String deleteRepeatedValuesAndSpaces (String line) {
        String lineUpperCase = line.trim().toUpperCase().replace(" ", "");
        StringBuilder finalLine = new StringBuilder().append(lineUpperCase.charAt(0));
        for (int i = 1; i < lineUpperCase.length(); i++) {
            if (lineUpperCase.charAt(i) == lineUpperCase.charAt(i - 1)) continue;
            finalLine.append(lineUpperCase.charAt(i));
        }
        return finalLine.toString();
    }

    public static String deleteAllRepeatedValuesAndSpaces (String line) {
        String lineUpperCase = line.trim().toUpperCase().replaceAll("\s", "");
        StringBuilder finalLine = new StringBuilder();
        for (int i = 0; i < lineUpperCase.length(); i++) {
            String regex = Character.valueOf(lineUpperCase.charAt(i)).toString();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(lineUpperCase);
            int matches = -1;
            while (matcher.find()) matches++;
            if (matches == 0) finalLine.append(lineUpperCase.charAt(i));
        }
        return finalLine.toString();
    }
}
