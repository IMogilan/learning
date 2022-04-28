package com.mogilan.practice;

/**Дан список целых чисел. Найти среднее всех нечетных чисел, делящихся на 5*/

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class Task1 {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 20, 25);
        //Option1
        OptionalDouble average = integers.stream()
                .mapToInt(Integer::intValue)
                .filter(value -> (value % 2 != 0) && (value % 5 == 0))
                .average();
        average.ifPresent(System.out::println);

//        Option 2
//        double average = integers.stream()
//                .mapToInt(Integer::intValue)
//                .filter(value -> (value % 2 != 0) && (value % 5 == 0))
//                .summaryStatistics()
//                .getAverage();
//        System.out.println(average);
    }

}
