package com.mogilan.practice;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**7. Написать свою реализацию интерфейса TemporalAdjuster, которая бы
 прибавляла к дате 42 дня*/

public class Task7 {
    public static void main(String[] args) {
        Instant now = Instant.now();
        Instant plusFortyTwoDays = now.with(temporal -> temporal.plus(42L, ChronoUnit.DAYS));
        System.out.println(now);
        System.out.println(plusFortyTwoDays);
    }
}
