package com.mogilan.practice1;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**5. Даны два объекта LocalDate из предыдущего задания. Подсчитать количество
 секунд между полуночью первой даты и полуночью второй даты.*/

public class Task5 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate date = LocalDate.of(2018, 7, 7);

//        LocalDateTime currentDateTime = LocalDateTime.of(now, LocalTime.MIDNIGHT);
//        LocalDateTime startDateTime = LocalDateTime.of(date, LocalTime.MIDNIGHT);
//        или
        LocalDateTime currentDateTime = now.atStartOfDay();
        LocalDateTime startDateTime = date.atStartOfDay();
//        long secBetween = ChronoUnit.SECONDS.between(startDateTime, currentDateTime);
//        System.out.println(secBetween);
//        или
        Duration duration = Duration.between(startDateTime, currentDateTime);
        System.out.println(duration.getSeconds());
    }
}
