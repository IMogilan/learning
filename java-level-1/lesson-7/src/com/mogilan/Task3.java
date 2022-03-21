package com.mogilan;

/* 3. Заданы 2 массива целых чисел произвольной длины. 
    Написать программу, создающую третий массив, представляющий собой слияние 2-х заданных.

Пример:

1-й массив: {1, 2, 3, 4, 5}
2-й массив: {5, 6, 7}

Результат: {1, 5, 2, 6, 3, 7, 4, 5}*/

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        System.out.println("Создаем 1й массив");
        int [] array1 = Task1.setArray();
        System.out.println("Создаем 2й массив");
        int [] array2 = Task1.setArray();
        System.out.println("Создан новый 3й массив: " + Arrays.toString(mergeArrays(array1, array2)));

    }

    public static int [] mergeArrays (int [] array1, int [] array2) {
        int array1CurrentIndex = 0;
        int array2CurrentIndex = 0;
        int [] array3 = new int [array1.length + array2.length];
        for (int i = 0; i < array3.length; ) {
        if ((array1CurrentIndex < array1.length) && (array2CurrentIndex < array2.length)) {
            array3[i++] = array1[array1CurrentIndex++];
            array3[i++] = array2[array2CurrentIndex++];
        } else if (array1CurrentIndex < array1.length) {
            array3[i++] = array1[array1CurrentIndex++];
        } else {
            array3[i++] = array2[array2CurrentIndex++];
        }
        }
        return array3;
    }
}
