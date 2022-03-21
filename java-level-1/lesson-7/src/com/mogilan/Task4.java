package com.mogilan;

/*4. Написать функцию linearize, которая принимает в качестве параметра двумерный массив
и возвращает одномерный массив со всеми элементами двумерного.*/

import java.util.Arrays;
import java.util.Scanner;

public class Task4 {
    

    public static void main(String[] args) {
        int [][] array = setArray2D();
        System.out.println("Создан новый массив: " + Arrays.toString(linearize(array)));

    }
    public static int [][] setArray2D () {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество строк (высоту) двумерного массива: ");
        int arrayLength = scanner.nextInt();
        if (arrayLength <= 0) {
            System.out.println("Введена некорректная длина массива");
            return null;
        }
        int [][] array2D = new int[arrayLength][];
        for (int i = 0; i < arrayLength; i++) {
            System.out.println("Создаем " + i + " строку двумерного массива");
            array2D[i] = Task1.setArray();
        }
        System.out.println("Создан следующий массив: ");
        System.out.println(Arrays.deepToString(array2D).replace("],", "],\n"));
        return array2D;
    }

    public static int [] linearize (int [][] array2D) {
        int arrayLength = 0;
        for (int i = 0; i < array2D.length; i++) {
            arrayLength += array2D[i].length;
            }
        int currentIndex = 0;
        int [] array = new int[arrayLength];
        for (int i = 0; i < array2D.length; i++) {
            for (int j = 0; j < array2D[i].length; j++) {
                 array[currentIndex] = array2D[i][j];
                 currentIndex++;
            }
        }
        return array;
    }
}
