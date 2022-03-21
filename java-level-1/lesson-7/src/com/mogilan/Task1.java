package com.mogilan;

/*1. Напишите программу, которая циклически сдвигает элементы массива вправо на одну позицию,
и печатает результат. Цикличность означает, что последний элемент массива становится самым первым
его элементом.*/

import java.util.Scanner;
import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        int [] array = setArray();
        moveArrayValues(array);
        moveArrayValues(array);
        moveArrayValues(array);
    }

    public static int [] setArray () {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длину массива: ");
        int arrayLength = scanner.nextInt();
        if (arrayLength <= 0) {
            System.out.println("Введена некорректная длина массива");
            return null;
        }
        int [] array = new int[arrayLength];
        System.out.print("Введите через пробел значения элементов массива: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println("Создан следующий массив: " + Arrays.toString(array));
     return array;
    }

    public static void moveArrayValues (int [] array) {
        int previousValue = array[0];
        for (int i = 1; i < array.length; i++) {
            int currentValue = array[i];
            array[i] = previousValue;
            previousValue = currentValue;
        }
        array[0] = previousValue;
        System.out.println("Измененный массив: " + Arrays.toString(array));
    }
}
