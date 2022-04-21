package com.mogilan.homework.task1;

import java.util.ArrayList;
import java.util.List;

public class Task1Runner {
    public static void main(String[] args) {
        Chat minsk = new Chat("Чат велосипедистов Минска", 5_000);
        Chat gomel = new Chat("Чат велосипедистов Гомеля", 3_000);
        Chat vitebsk = new Chat("Чат велосипедистов Витебска", 500);
        Chat grodno = new Chat("Чат велосипедистов Гродно", 700);
        Chat brest = new Chat("Чат велосипедистов Бреста", 5_000);
        Chat mogilev = new Chat("Чат велосипедистов Могилева", 4_000);

        List<Chat> chats =  new ArrayList<> (List.of(minsk, gomel, vitebsk, grodno, brest, mogilev));
        System.out.println("Начальный перечень всех чатов:\n" + chats);

        ChatUtil.removeSmallerThanMinimalLength(chats);
        System.out.println("Перечень чатов после исключения чатов меньше минимального количества пользователей:\n" + chats);

        ChatUtil.sortNumberOfUsersAndName(chats);
        System.out.println("Перечень чатов после сортировки по количеству и наименованиям:\n" + chats);

        System.out.println(gomel.compareTo(minsk));

        ChatUtil.sort(chats);
        System.out.println("Перечень чатов после сортировки по умолчанию:\n" + chats);

    }
}
