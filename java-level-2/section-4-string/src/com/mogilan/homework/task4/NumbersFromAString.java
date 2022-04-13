package com.mogilan.homework.task4;

/*Дана строка с текстом, в котором есть цифры от 0 до 9.
Написать 2 метода:
- возвращающий массив цифр из переданной строки
- возвращающий сумму цифр из переданного целочисленного массива
Посчитать сумму всех чисел из строки
Например:
“Привет 8, как 1 2 твои дела? Может4, сделать 3 дело?” -> 18 (8+1+2+4+3)*/

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumbersFromAString {
    public static void main(String[] args) {
        String line = "Привет 8, как 1 2 твои дела? Может4, сделать 3 дело?";
        int [] allNumbersOfTheLine = getAllNumbersOfTheLine(line);
        System.out.println(Arrays.toString(allNumbersOfTheLine));
        System.out.println(getSumAllNumbersOfTheLine(allNumbersOfTheLine));

    }

    private static Object getSumAllNumbersOfTheLine(int[] allNumbersOfTheLine) {
        int result = 0;
        for (int i : allNumbersOfTheLine) {
            result += i;
        }
        return result;
    }

    private static int[] getAllNumbersOfTheLine(String line) {
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(line);
        StringBuilder lineOfNumbers = new StringBuilder();
        while (matcher.find()) lineOfNumbers.append(matcher.group());
        int [] result = new int[lineOfNumbers.length()];
        for (int i = 0; i < result.length; i++) result [i] = Character.getNumericValue(lineOfNumbers.charAt(i));
        return result;
    }

//    Option 2 (without RegEx)
//    private static int[] getAllNumbersOfTheLine(String line) {
//        int [] allNumbersOfTheLine = new int[line.length()];
//        char [] numbers = {'1', '2', '3', '4', '5', '6', '7', '8' , '9', '0'};
//        int counter = 0;
//        for (int i = 0; i < line.length(); i++) {
//            for (int j = 0; j < numbers.length; j++) {
//                if (line.charAt(i) == numbers[j]) allNumbersOfTheLine [counter++] = Character.getNumericValue(numbers[j]);
//            }
//        }
//        int [] resultArray = new int[counter];
//        for (int i = 0; i < resultArray.length; i++) {
//            resultArray [i] = allNumbersOfTheLine [i];
//        }
//        return resultArray;
//    }

}
