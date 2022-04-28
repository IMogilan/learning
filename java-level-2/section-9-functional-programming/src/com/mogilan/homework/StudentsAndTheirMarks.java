package com.mogilan.homework;

import java.util.List;

public class StudentsAndTheirMarks {
    private List<String> students;
    private double averageMark;

    public StudentsAndTheirMarks(List<String> students) {
        this.students = students;
    }

    public StudentsAndTheirMarks(List<String> students, double averageMark) {
        this.students = students;
        this.averageMark = averageMark;
    }

    public List<String> getStudents() {
        return students;
    }

    public void setStudents(List<String> students) {
        this.students = students;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }

    @Override
    public java.lang.String toString() {
        return "StudentsAndTheirMarks{" +
                "students=" + students +
                ", averageMark=" + averageMark +
                '}';
    }
}
