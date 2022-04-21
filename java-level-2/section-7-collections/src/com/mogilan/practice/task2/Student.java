package com.mogilan.practice.task2;

public class Student {
    private final String firstName;
    private final String lastName;
    private int age;
    private double averageMarkForTheYear;

    public Student(String firstName, String lastName, int age, double averageMarkForTheYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.averageMarkForTheYear = averageMarkForTheYear;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", averageScoreForTheYear=" + averageMarkForTheYear +
                '}' + "\n";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAverageMarkForTheYear() {
        return averageMarkForTheYear;
    }

    public void setAverageMarkForTheYear(double averageMarkForTheYear) {
        this.averageMarkForTheYear = averageMarkForTheYear;
    }
}
