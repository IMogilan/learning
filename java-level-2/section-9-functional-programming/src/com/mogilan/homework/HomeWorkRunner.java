package com.mogilan.homework;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**Домашнее задание
 Дан список студентов с полями:
 - Имя
 - Фамилия
 - Номер курса в университете
 - Список оценок за учебу

 Преобразовать этот список студентов в ассоциативный массив, где ключом является номер курса, а значением:

 1) Средняя оценка студентов этого курса, количество оценок у которых больше 3-х

 2) Список студентов данного курса, но только с полями Имя и Фамилия.
 Список должен быть отсортированы по этим двум полям

 3) Объект с двумя полями:
 - Отсортированный список студентов с пункта 2
 - Средняя оценка этих студентов

 Подумать, как ассоциативный массив можно было представить в коде в виде отсортированного - TreeMap

 */

public class HomeWorkRunner {
    public static void main(java.lang.String[] args) {
        List<Student> students = List.of(
                new Student("Petr", "Petrov", 1, List.of(8.5, 9.0, 9.5)),
                new Student("Ivan", "Ivanov", 2, List.of(8.5, 9.0, 9.5)),
                new Student("Zak", "Zakov", 2, List.of(8.5, 9.0, 9.5)),
                new Student("Allan", "Allanov", 2, List.of(8.5, 9.0, 9.5)),
                new Student("Yohan", "Yohanov", 2, List.of(8.5, 9.0, 9.5)),
                new Student("Katya", "Katina", 3, List.of(9.2, 8.5, 8.8)),
                new Student("Olya", "Olina", 2, List.of(8.5, 9.0, 9.5)),
                new Student("Tanya", "Tanina", 4, List.of(8.9, 9.0, 8.8))
        );

        // (1)
        Map<Integer, Double> mapByCourseAndMarks = StudentUtil.listToMapByCourseAndMarks(students);
        System.out.println(mapByCourseAndMarks);

        // (2)
        Map<Integer, List<java.lang.String>> mapByCourseAndFullName = StudentUtil.listToMapByCourseAndFullName(students);
        System.out.println(mapByCourseAndFullName);

        // (3)
        // Step 1
        Map<Integer, StudentsAndTheirMarks> mapOfObjects = mapByCourseAndFullName.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> new StudentsAndTheirMarks(entry.getValue())));
        // Step 2
        mapOfObjects.entrySet().stream()
               .forEach(entry -> entry.getValue().setAverageMark(mapByCourseAndMarks.getOrDefault(entry.getKey(), null)));

        System.out.println(mapOfObjects);


    }
}
