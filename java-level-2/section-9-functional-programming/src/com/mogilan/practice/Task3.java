package com.mogilan.practice;

import java.util.Map;

/**Дана Map <String, Integer>. Найти сумму всех значений, длина ключей которых меньше 7 символов */

public class Task3 {
    public static void main(String[] args) {
        Map<String, Integer> map = Map.of(
                "1", 5,
                "12", 5,
                "123", 5,
                "1234", 5,
                "12345", 5,
                "123456", 5,
                "1234567", 5,
                "12345678", 5,
                "123456789", 5,
                "1234567890", 5
        );
        int result = map.entrySet().stream()
                .filter(entry -> entry.getKey().length() < 7)
                .mapToInt(Map.Entry::getValue)
                .sum();
        System.out.println(result);
    }
}
