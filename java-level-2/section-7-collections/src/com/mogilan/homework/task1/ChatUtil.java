package com.mogilan.homework.task1;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class ChatUtil {

    private static final int MINIMAL_LENGTH = 1000;

    private ChatUtil (){}

    public static void removeSmallerThanMinimalLength (List<Chat> chats) {
        Iterator<Chat> iterator = chats.iterator();
        while (iterator.hasNext()) {
            Chat current = iterator.next();
            if (current.getNumberOfUsers() < MINIMAL_LENGTH) iterator.remove();
        }
    }

    public static void sort(List<Chat> list) {
        list.sort(new nameComparator());
    }

    public static void sortNumberOfUsersAndName(List<Chat> list) {
        list.sort(new numberOfUsersComparator().thenComparing(new nameComparator()));
    }

    public static class numberOfUsersComparator implements Comparator <Chat> {

        @Override
        public int compare(Chat o1, Chat o2) {
            return Integer.compare(o1.getNumberOfUsers(), o2.getNumberOfUsers());
        }
    }

    public static class nameComparator implements Comparator <Chat> {

        @Override
        public int compare(Chat o1, Chat o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

}
