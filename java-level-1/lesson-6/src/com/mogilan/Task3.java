package com.mogilan;

/*3. Написать программу, отображающую статистику по осадкам за N дней. N вводится пользователем.
    Пользователь также должен ввести N целых чисел, обозначающих величину осадков в день.
    Программа должна выводить:
a. Количество дней
b. Сумму осадков за этот период
c. Среднее количество осадков за этот период
d. Максимальное количество дневных осадков за этот период
    Не использовать массивы!
*/

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
    statisticsOfPrecipitation();

    }

    public static void statisticsOfPrecipitation () {
        Scanner scannerDays = new Scanner(System.in);
        System.out.print("Введите общее количество дней: ");
        int numberOfDays = scannerDays.nextInt();
        System.out.println();
        int currentDay = 1;
        int precipitationForAllPeriod = 0;
        int maxPrecipitation = 0;
        while (currentDay <= numberOfDays) {
            System.out.print("Введите количество осадков, которое выпало в " + currentDay + "-й день: ");
            int currentPrecipitation = scannerDays.nextInt();
            precipitationForAllPeriod += currentPrecipitation;
            if (currentPrecipitation > maxPrecipitation) maxPrecipitation = currentPrecipitation;
            currentDay++;
        }
        System.out.println();
        System.out.println("Количество дней: " + numberOfDays);
        System.out.println("Сумма осадков за этот период: " + precipitationForAllPeriod);
        System.out.println("Среднее количество осадков за этот период: " + (((double)precipitationForAllPeriod)/numberOfDays));
        System.out.println("Максимальное количество дневных осадков за этот период: " + maxPrecipitation);
    }
}
