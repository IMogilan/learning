package com.mogilan.practice;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class PracticeRunner {
    public static void main(String[] args) throws IOException {
        Path pathOfOriginalLogFile = Path.of("src", "com", "mogilan", "practice", "resources", "log-file.txt");
        CourseScheduleGenerator.generateSchedule(pathOfOriginalLogFile, 4);

        Path pathOfReportOfTimePeriods = Path.of("src", "com", "mogilan", "practice", "resources", "reportOfTimePeriods.txt");
        Files.writeString(pathOfReportOfTimePeriods, " ", StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        ReportOfTimePeriods.generateReport(pathOfOriginalLogFile, pathOfReportOfTimePeriods);

        Path pathOfStatisticsReport = Path.of("src", "com", "mogilan", "practice", "resources", "statisticReport.txt");
        Files.writeString(pathOfStatisticsReport, " ", StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        StatisticReport.generateReport(pathOfOriginalLogFile, pathOfStatisticsReport);

    }
}
