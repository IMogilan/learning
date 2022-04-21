package com.mogilan.practice.task2;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class StudentUtil {

    private StudentUtil (){}

    public static Student getBestStudent(List<Student> students) {
        if (!students.isEmpty()) {
//            Collections.sort(students, new StudentUtil.scoreComparator());
//            return students.get(students.size() - 1);
            Student bestStudent = students.get(0);
            Iterator<Student> iterator = students.iterator();
            while (iterator.hasNext()) {
                Student current = iterator.next();
                if (current.getAverageMarkForTheYear() > bestStudent.getAverageMarkForTheYear()) bestStudent = current;
            }
            return bestStudent;
        } else return null;
    }


    public static class nameComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            String o1FullName = o1.getFirstName() + o1.getLastName();
            String o2FullName = o2.getFirstName() + o2.getLastName();
            return o1FullName.compareTo(o2FullName);
        }
    }

    public static class ageComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return Integer.compare(o1.getAge(), o2.getAge());
        }
    }

    public static class scoreComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return Double.compare(o1.getAverageMarkForTheYear(), o2.getAverageMarkForTheYear());
        }
    }
}
