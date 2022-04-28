package com.mogilan.homework;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class StudentUtil {

    private StudentUtil() {}

    public static Map <Integer, Double> listToMapByCourseAndMarks (List<Student> studentList) {
        Map<Integer, Double> studentsMap = studentList.stream()
                .filter(student -> student.getMarks().size() > 2)
                .collect(Collectors.groupingBy(Student::getCourseNumber,
                         Collectors.mapping(Student::getAverageMark, Collectors.averagingDouble(mark -> mark.orElse(0.0)))));
        return studentsMap;
    }
    public static Map <Integer, List<java.lang.String>> listToMapByCourseAndFullName (List<Student> studentList) {
        Map<Integer, List<java.lang.String>> mapByCourseAndFullName = studentList.stream()
                .sorted(Comparator.comparing(Student::getFullName))
                .collect(Collectors.groupingBy(Student::getCourseNumber, Collectors.mapping(Student::getFullName, Collectors.toList())));
        return mapByCourseAndFullName;

    }

}
