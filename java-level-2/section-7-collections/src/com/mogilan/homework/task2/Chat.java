package com.mogilan.homework.task2;

import java.util.List;

public class Chat implements Comparable <com.mogilan.homework.task1.Chat>{
        private String name;
        private List<User> users;

    public Chat(String name, List<User> users) {
        this.name = name;
        this.users = users;
    }

    @Override
        public int compareTo(com.mogilan.homework.task1.Chat o) {
            return this.getName().compareTo(o.getName());
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
