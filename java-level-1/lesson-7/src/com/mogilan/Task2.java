package com.mogilan;

/*2. Написать программу, удаляющую все повторяющиеся целые числа из массива и печатающую результат.
Массив должен использоваться тот же самый. На место удаленных элементов ставить цифру 0.*/

// Задача решена исходя из предположения, что "все повторяющиеся целые числа" подразумевают в том числе первое самое первое из данных чисел

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        int [] array = Task1.setArray();
        deleteRepeatedValues(array);
    }

    public static void deleteRepeatedValues (int [] array) {
        for (int i = 0; i < array.length; i++) {
            boolean isRepeated = false;
            for (int j = i + 1; j < array.length; j++) {
                if (array [i] == array [j]) {
                    array [j] = 0;
                    isRepeated = true;
                }
            }
            if (isRepeated) array [i] = 0;
        }
        System.out.println("Измененный массив: " + Arrays.toString(array));
    }
}
