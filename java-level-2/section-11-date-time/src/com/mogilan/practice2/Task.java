package com.mogilan.practice2;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**Написать свою реализацию интерфейса TemporalAdjuster, которая бы изменяла дату на ближайшее (в днях) 1 января.*/

public class Task {
    public static void main(String[] args) {
        LocalDate currentDay = LocalDate.now();
        LocalDate nearestNewYear = currentDay.with(temporal -> Task.findNearestNewYear((LocalDate) temporal));
        System.out.println(nearestNewYear);


    }

    public static LocalDate findNearestNewYear (LocalDate currentDay) {
        int currentYear = currentDay.getYear();
        LocalDate firstJanuaryOfCurrentYear = LocalDate.of(currentYear, 1, 1);
        int nextYear = currentYear + 1;
        LocalDate firstJanuaryOfNextYear = LocalDate.of(nextYear, 1, 1);
        if (ChronoUnit.DAYS.between(firstJanuaryOfCurrentYear, currentDay) < ChronoUnit.DAYS.between(currentDay, firstJanuaryOfNextYear)) return firstJanuaryOfCurrentYear;
        else return firstJanuaryOfNextYear;
    }

}
