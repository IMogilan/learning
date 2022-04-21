package com.mogilan.homework.task1;

public class Chat implements Comparable <Chat>{
    private String name;
    private int numberOfUsers;

    public Chat(String name, int numberOfUsers) {
        this.name = name;
        this.numberOfUsers = numberOfUsers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public void setNumberOfUsers(int numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "name='" + name + '\'' +
                ", numberOfUsers=" + numberOfUsers +
                '}' + "\n";
    }

    @Override
    public int compareTo(Chat o) {
        return this.getName().compareTo(o.getName());
    }
}
