package com.mogilan.practice;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.mogilan.practice.ScheduleUtil.*;
import static java.nio.file.StandardOpenOption.*;

public final class CourseScheduleGenerator {


    private static Queue <String> lectures = new LinkedList<>(List.of("Введение", "Скаляры", "Массивы",
            "Углубленное изучение массивов", "Циклы", "ООП", "Углубленное изучение ООП", "Классы и объекты", "Обобщения", "Углубленное изучение обобщений",
            "Исключения", "Ввод-вывод", "Многопоточность", "Util.concurrency", "Регулярные выражения", "Reflection"));
    private static Random random = new Random();

    private CourseScheduleGenerator() { }

    public static void generateSchedule (Path path, int numberOfDays) throws IOException {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path, CREATE, TRUNCATE_EXISTING)) {
            bufferedWriter.write("");
        }
        int currentDay = 1;
        while (currentDay <= numberOfDays && !lectures.isEmpty()) {
            currentDay++;
            String currentDaySchedule = dayBuilder();
            try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path, CREATE, APPEND)) {
                bufferedWriter.write(currentDaySchedule);
            }
        }
    }

    private static String dayBuilder () {
        StringBuilder daySchedule = new StringBuilder();
        LocalTime startTime = randomStartTime();
        appendLecture(daySchedule, startTime);
        startTime = endOfPrevious(startTime, true);
        while (startTime.plusMinutes(30).isBefore(END_OF_THE_DAY)) {
            int j = random.nextInt(2) + 1;
            for (int i = 0; i <= j; i++) {
                appendActivity(daySchedule, startTime);
                startTime = endOfPrevious(startTime, false);
                if (startTime.plusMinutes(30).isBefore(END_OF_THE_DAY)) break;
            }
            appendLecture(daySchedule, startTime);
            startTime = endOfPrevious(startTime, true);
        }
        daySchedule.append(formatterOfLocalTime(startTime) + " Конец\n\n");
        return daySchedule.toString();
    }

    private static void appendLecture(StringBuilder daySchedule, LocalTime startTime) {
        String currentLecture = lectures.remove();
        daySchedule.append(formatterOfLocalTime(startTime) + " "
                + currentLecture + "\n");
        lectures.add(currentLecture);
    }

    private static void appendActivity(StringBuilder daySchedule, LocalTime startTime) {
        daySchedule.append(formatterOfLocalTime(startTime) + " "
                + ACTIVITIES.get(random.nextInt(ACTIVITIES.size())) + "\n");
    }

    private static LocalTime endOfPrevious(LocalTime startOfPrevious, boolean isPreviousLecture) {
        int minDurationInMinutes, maxDurationInMinutes;
        if (isPreviousLecture) {
            minDurationInMinutes = LECTURES_MIN_DURATION_IN_MINUTES;
            maxDurationInMinutes = LECTURES_MAX_DURATION_IN_MINUTES;
        } else {
            minDurationInMinutes = ACTIVITIES_MIN_DURATION_IN_MINUTES;
            maxDurationInMinutes = ACTIVITIES_MAX_DURATION_IN_MINUTES;
        }
        int delta = maxDurationInMinutes - minDurationInMinutes;
        int randomDuration = random.nextInt(delta) + minDurationInMinutes;
        int randomDurationRoundingUpToFiveMinutes = randomDuration - (randomDuration % 5);
        return startOfPrevious.plusMinutes(randomDurationRoundingUpToFiveMinutes);
    }

    private static LocalTime randomStartTime () {
        int startRandom = random.nextInt(2);
        if (startRandom == 0) return LocalTime.of(9, 20);
        else return LocalTime.of(9, 30);
    }

    private static String formatterOfLocalTime (LocalTime localTime) {
        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("HH:mm");
        String formattedTime = localTime.format(formatter);
        return formattedTime;
    }
}
