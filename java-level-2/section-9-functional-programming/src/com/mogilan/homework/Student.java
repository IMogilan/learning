package com.mogilan.homework;

import java.util.List;
import java.util.OptionalDouble;

public class Student implements Comparable <Student>{
    private final java.lang.String firstName;
    private final java.lang.String lastName;
    private int courseNumber;
    private List<Double> marks;

    public Student(java.lang.String firstName, java.lang.String lastName, int courseNumber, List<Double> marks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.courseNumber = courseNumber;
        this.marks = marks;
    }

    public Student(java.lang.String firstName, java.lang.String lastName, int courseNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.courseNumber = courseNumber;
    }

    public OptionalDouble getAverageMark () {
        return marks.stream().mapToDouble(Double::doubleValue).average();
    }

    public java.lang.String getFullName (){
        return firstName + " " + lastName;
    }

    public java.lang.String getFirstName() {
        return firstName;
    }

    public java.lang.String getLastName() {
        return lastName;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public List<Double> getMarks() {
        return marks;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public void setMarks(List<Double> marks) {
        this.marks = marks;
    }

    @Override
    public java.lang.String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", courseNumber=" + courseNumber +
                ", marks=" + marks +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.getFullName().compareTo(o.getFullName());
    }
}
