package com.mogilan.homework.task2;

import java.util.Iterator;
import java.util.List;

public final class UsetUtil {

    private UsetUtil (){}

    public static double mediumAgeOfUsers (List<User> users) {
        Iterator <User> iterator = users.iterator();
        int numberOfUsers = 0;
        int ageOfAllUsers = 0;
        while (iterator.hasNext()) {
            User currentUser = iterator.next();
            numberOfUsers++;
            ageOfAllUsers += currentUser.getAge();
        }
        return ((double) ageOfAllUsers) / numberOfUsers;
    }
}
