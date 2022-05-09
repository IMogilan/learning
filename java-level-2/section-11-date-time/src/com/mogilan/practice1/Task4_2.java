package com.mogilan.practice;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

/**4. Создать объект LocalDate, представляющий собой сегодняшнюю
 дату. Создать объект LocalDate, представляющий собой дату
 07.07.2018. Используя созданные объекты, найти количество дней между
 этими двумя датами.*/

public class Task4_2 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate date = LocalDate.of(2018, 7, 7);

        long days = ChronoUnit.DAYS.between(date, now);
        System.out.println(days);

    }
}
