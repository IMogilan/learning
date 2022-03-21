package com.mogilan;

/* 2. Написать программу, вычисляющую и отображающую все числа Фибоначчи меньше введённого пользователем целого числа.
    Решить двумя способами: с помощью цикла и с помощью рекурсии.
*/

public class Task2 {
    public static void main(String[] args) {
        searchFibbonacci(34);
        System.out.println();
        searchFibbonacciRecursionInit(34);
    }

    public static void searchFibbonacci (int value) {
        if (value < 0) System.out.println("Число должно быть положительным");
        if (value == 0) System.out.print (0);
            else if (value == 1) System.out.print (0 + " " + 1);
                else {
                    System.out.print (0 + " " + 1 + " ");
                    int currentValue = 1;
                    int ultimateValue = 1;
                    int penultimateValue = 0;
                    while (currentValue <= value) {
                        currentValue = penultimateValue + ultimateValue;
                        if (currentValue > value) break;
                        System.out.print(currentValue + " ");
                        penultimateValue = ultimateValue;
                        ultimateValue = currentValue;
                    }
                }
    }

    public static void searchFibbonacciRecursionInit (int value) {
        if (value < 0) System.out.println("Число должно быть положительным");
        if (value == 0) System.out.print (0);
        else if (value == 1) System.out.print (0 + " " + 1);
            else {
            System.out.print (0 + " " + 1 + " ");
            searchFibbonacciRecursion (value, 1, 0);
            }
        }

    public static void searchFibbonacciRecursion (int value, int ultimateValue, int penultimateValue) {
        int currentValue = penultimateValue + ultimateValue;
        if (currentValue > value) return;
        System.out.print(currentValue + " ");
        penultimateValue = ultimateValue;
        ultimateValue = currentValue;
        searchFibbonacciRecursion(value, ultimateValue, penultimateValue);
    }
}

