package com.mogilan.practice;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**Дан список строк. Найти количество уникальных строк длиной более 8 символов*/

public class Task2 {
    public static void main(String[] args) {
        List<String> strings = List.of(
                "12345678-1",
                "12345678-15",
                "12345678-10",
                "12345678-10",
                "12345678-13",
                "12345678",
                "12345678");

        //Option 1
        HashSet<String> set = new HashSet<>(strings);
        long result1 = set.stream()
                .filter(string -> string.matches(".{9,}"))
                .count();
        System.out.println(result1);

        //Option 2
        long result2 = strings.stream()
                .filter(string -> string.length() > 8)
                .distinct()
                .count();
        System.out.println(result2);

        // Option 3
        int result3 = strings.stream()
                .filter(string -> string.length() > 8)
                .collect(Collectors.toSet())
                .size();
        System.out.println(result3);
    }
}
