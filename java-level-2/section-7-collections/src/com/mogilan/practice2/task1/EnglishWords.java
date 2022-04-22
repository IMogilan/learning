package com.mogilan.practice2.task1;

import java.util.Arrays;

import static com.mogilan.practice2.task1.WordsUtil.*;

/**1. Задан текст на английском языке. Выделить все различные слова.
 * Для каждого слова подсчитать частоту его встречаемости.
 * Слова, отличающиеся регистром букв, считать различными.*/

public class EnglishWords {
    public static void main(String[] args) {
        String text = "Hello, I am a student. I am studding Java. Java is a great language!";

        System.out.println(getUniqueWords(text));
        System.out.println(frequencyOfWords(text));

        // Метод splitTextToArray был добавлен в программу просто для тренировки регулярных выражений. Данный метод можно было использовать в программе
        // вместо метода splitTextToList.
        System.out.println(Arrays.toString(splitTextToArray(text)));
        
    }


}