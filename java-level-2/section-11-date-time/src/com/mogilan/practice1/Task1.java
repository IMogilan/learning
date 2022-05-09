package com.mogilan.practice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**1. Создать объект LocalDateTime, представляющий собой
 дату 25.06.2020 19:47. Используя этот объект, создать другой объект LocalDateTime,
 представляющий собой дату через 3 месяца после сегодняшней.
 Вывести на консоль содержащиеся в нем объеты LocalDate and LocalTime.
 */

public class Task1 {
    public static void main(String[] args) {
        LocalDateTime initialLocalDateTime = LocalDateTime.of(2020, 6, 25, 19, 47);
        LocalDateTime newLocalDateTime = initialLocalDateTime.plusMonths(3L);
        LocalDate newLocalDate = newLocalDateTime.toLocalDate();
        LocalTime newLocalTime = newLocalDateTime.toLocalTime();
        System.out.println("newLocalDate: " + newLocalDate + "\nnewLocalTime: " + newLocalTime);
    }
}
