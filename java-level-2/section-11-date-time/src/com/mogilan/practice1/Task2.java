package com.mogilan.practice1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**2. Создать объект LocalDate, представляющий собой сегодняшнюю
 дату. Преобразовать дату в строку вида "05.05.2017". Вывести эту строку на
 консоль.*/

public class Task2 {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = currentDate.format(formatterDate);
        System.out.println(formattedDate);

        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatterDateTime = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        System.out.println(currentDateTime.format(formatterDateTime));
    }
}
