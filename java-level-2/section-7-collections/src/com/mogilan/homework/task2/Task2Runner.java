package com.mogilan.homework.task2;

import java.util.ArrayList;
import java.util.List;

public class Task2Runner {
    public static void main(String[] args) {
        User user1 = new User(1, "Петя", 20);
        User user2 = new User(2, "Ваня", 10);
        User user3 = new User(3, "Надя", 15);
        User user4 = new User(4, "Люда", 30);
        User user5 = new User(5, "Костя", 20);
        User user6 = new User(6, "Антон", 14);
        User user7 = new User(7, "Юля", 40);
        User user8 = new User(8, "Стас", 11);
        User user9 = new User(9, "Катя", 30);
        User user10 = new User(10, "Таня", 33);

        Chat chat1 = new Chat("Чат 1", new ArrayList<>(List.of(user1, user2)));
        Chat chat2 = new Chat("Чат 2", new ArrayList<>(List.of(user3, user4)));
        Chat chat3 = new Chat("Чат 3", new ArrayList<>(List.of(user5, user6, user7)));
        Chat chat4 = new Chat("Чат 4", new ArrayList<>(List.of(user8, user9, user10)));

        ArrayList<Chat> chats = new ArrayList<>(List.of(chat1, chat2, chat3, chat4));

        List<User> adults = ChatUtil.getAdults(chats);
        System.out.println("Список совершеннолетних пользователей: \n" + adults);

        double mediumAgeOfAllAdults = UsetUtil.mediumAgeOfUsers(adults);
        System.out.println("Средний возраст всех совершеннолетних пользователей: " + mediumAgeOfAllAdults);

    }
}
