package com.mogilan.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task2PracticeRunner {
    public static void main(String[] args) {
        /*Task 2.
        Создать класс Student, представляющий собой ученика. Добавить ему данные об имени, фамилии, возрасте
        и среднем балле за год.
        Создать список (List) учеников. Найти и вывести ученика с самым высоким средним баллом используя итератор.
        Отсортировать и вывести список учеников по полному имени (имя + фамилия), возрасту и среднему баллу,
        используя компараторы.*/

        List<Student> studentsNull = Arrays.asList();
        System.out.println(StudentUtil.getBestStudent(studentsNull));

        List<Student> students = Arrays.asList(
                new Student("Петя", "Петров", 20, 8.5),
                new Student("Иван", "Иванов", 22, 9.2),
                new Student("Оля", "Ольгина", 21, 8.8),
                new Student("Люда", "Людикова", 19, 9.4)
        );
        System.out.println(StudentUtil.getBestStudent(students));

        System.out.println("Сортировка по полному имени (имя + фамилия): \n");
        Collections.sort(students, new StudentUtil.nameComparator());
        System.out.println(students);

        System.out.println("Сортировка по возрасту: \n");
        Collections.sort(students, new StudentUtil.ageComparator());
        System.out.println(students);

        System.out.println("Сортировка по среднему балу: \n");
        Collections.sort(students, new StudentUtil.scoreComparator());
        System.out.println(students);

    }
}
