package com.mogilan.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Task1PracticeRunner {
    public static void main(String[] args) {

        /* Task 1.
        Написать метод markLength4, принимающий в качестве параметра список (List) строк и размещающий строку "****" перед каждым
        четырёхсимвольным элементом. Оригинальные элементы должны остаться на месте.
        Например:
        {"this", "is", "lots", "of", "fun", "for", "every", "Java", "programmer"}
        ->
        {"****", "this", "is", "****", "lots", "of", "fun", "for", "every", "****", "Java", "programmer"}*/

        String [] array = {"this", "is", "lots", "of", "fun", "for", "every", "Java", "programmer"};
        List<String> list = new ArrayList<String>();
        for (String s : array) {
            list.add(s);
        }
        MarkLength.markLength4(list);
        System.out.println(list);

        List<String> list2 = new ArrayList<>(List.of("this", "is", "lots", "of", "fun", "for", "every", "Java", "programmer"));
        MarkLength.markLength4(list2);
        System.out.println(list2);

        List<String> list3 = new LinkedList<>(List.of("this", "is", "lots", "of", "fun", "for", "every", "Java", "programmer"));
        MarkLength.markLength4(list3);
        System.out.println(list3);
    }
}
