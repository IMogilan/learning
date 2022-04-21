package com.mogilan.homework.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class ChatUtil {

    private ChatUtil() {}

    public static List<User> getAdults(List<Chat> chats) {
        List<User> listOfAdults = new ArrayList<>();
        Iterator<Chat> iteratorChats = chats.iterator();
        while (iteratorChats.hasNext()) {
            Chat currentChat = iteratorChats.next();
            Iterator<User> iteratorUsers = currentChat.getUsers().iterator();
            while (iteratorUsers.hasNext()) {
                User currentUser = iteratorUsers.next();
                if (currentUser.getAge() >= 18) listOfAdults.add(currentUser);
            }
        }
        return listOfAdults;
    }
}
