package com.mogilan;

/*1. Написать программу, вычисляющую сумму цифр введённого пользователем целого числа.*/

public class Task1 {
    public static void main(String[] args) {
        int value = 1117;
        System.out.println(sumOfNumbers(value));
    }

    public static int sumOfNumbers (int value) {
        int result = 0;
        for (int currentValue = value; currentValue > 0; currentValue /= 10) {
            result += currentValue % 10;
        }
        return result;
    }

}
