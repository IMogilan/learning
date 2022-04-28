package com.mogilan.practice;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**Дан класс Person с полями firstName, lastName и age.
 * Вывести полное имя самого старшего человека, у которого
 * длина этого имени не превышает 15 символов.
 * */

public class Task5 {
    public static void main(String[] args) {
        List<Person> persons = List.of(
                new Person("Ivan", "Ivanov", 20),
                new Person("Petr", "Petrov", 30),
                new Person("Kirill", "Kirillov", 40),
                new Person("Olya", "Oliiiiiiiiiiina", 101),
                new Person("Katya", "Katina", 60),
                new Person("Stas", "Stasov", 70),
                new Person("Kostya", "Kostikov", 80),
                new Person("Natan", "Natanov", 90)
        );
         persons.stream()
                .filter(person -> person.getFullName().length() < 15)
                .max(Comparator.comparingInt(Person::getAge))
                .map(Person::getFullName)
                .ifPresent(System.out::println);
    }
}
