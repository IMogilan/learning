package com.mogilan.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;

import static com.mogilan.practice.ScheduleUtil.*;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public final class StatisticReport {

    private static Map <String, Integer> dayStatistics = new HashMap <> ();
    private static Map <String, Integer> lecturesStatistics = new HashMap<>();
    private static int dayNumber = 1;
    private static int totalTimeSpent = 0;

    private StatisticReport() {}

    public static void generateReport (Path pathOfOriginalLogFile, Path pathOfReport) throws IOException {
        Scanner scanner = new Scanner(pathOfOriginalLogFile);
        while (scanner.hasNextLine()) {
            String prevLine;
            do {
                prevLine = scanner.nextLine();
            } while (prevLine.isBlank());
            Matcher matcher = PATTERN.matcher(prevLine);
            matcher.find();
            LocalTime prevStartTime = LocalTime.parse(matcher.group("time"));
            String prevName = matcher.group("name");
            while (scanner.hasNextLine()) {
                String newLine = scanner.nextLine();
                if (!newLine.isBlank()) {
                    matcher = PATTERN.matcher(newLine);
                    matcher.find();
                    LocalTime prevEndTime = LocalTime.parse(matcher.group("time"));
                    putNewValueToAllMaps(prevName, prevStartTime, prevEndTime);
                    prevStartTime = prevEndTime;
                    prevName = matcher.group("name");
                } else {
                    break;
                }
            }
           writeDayStatistic(pathOfReport);
        }
      writeLecturesStatistics(pathOfReport);
    }

    private static void putNewValueToAllMaps (String name, LocalTime start, LocalTime end) {
        Integer duration =  (int) ChronoUnit.MINUTES.between(start, end);
        String currentName = name;
        if (isLecture(name)) {
            putNewValueToMap(lecturesStatistics, name, duration);
            currentName = "Лекции";
        }
        putNewValueToMap(dayStatistics, currentName, duration);
    }

    private static void putNewValueToMap(Map <String, Integer> currentMap, String name, Integer duration) {
        Integer currentValue = currentMap.getOrDefault(name, 0);
        Integer newValue = (currentValue == 0 ? duration : currentValue + duration);
        if (currentValue > 0) {
            currentMap.replace(name, newValue);
        } else {
            currentMap.put(name, newValue);
        }
    }

    private static void writeDayStatistic (Path pathOfReport) throws IOException {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(pathOfReport, CREATE, APPEND)) {
            int totalTimeSpentThisDay = dayStatistics.values().stream().mapToInt(Integer::valueOf).sum();
            totalTimeSpent += totalTimeSpentThisDay;
            bufferedWriter.write("День " + (dayNumber++) + "\n");
            dayStatistics.entrySet().stream()
                    .forEach(entry -> {
                        try {
                            String currentLine = String.format("%s: %d минут, %f %%\n", entry.getKey(), entry.getValue(), (entry.getValue()/ (double) totalTimeSpentThisDay * 100));
                            bufferedWriter.write(currentLine);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
            bufferedWriter.write ("\n");
        }
        dayStatistics.clear();
    }

    private static void writeLecturesStatistics (Path pathOfReport) throws IOException {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(pathOfReport, CREATE, APPEND)) {
            bufferedWriter.write ("Лекции:\n");
            lecturesStatistics.entrySet().stream()
                    .forEach(entry -> {
                        try {
                            bufferedWriter.write(String.format("%s: %d минут, %f %%\n", entry.getKey(), entry.getValue(), (entry.getValue()/ (double) totalTimeSpent * 100)));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }

    private static boolean isLecture(String name) {
        return !ACTIVITIES.contains(name);
    }


}
