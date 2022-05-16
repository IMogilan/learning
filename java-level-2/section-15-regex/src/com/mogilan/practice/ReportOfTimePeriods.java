package com.mogilan.practice;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public final class ReportOfTimePeriods {

    public static final String REG_EX = "(?<time>\\d{2}:\\d{2})\\s(?<name>.+)";
    public static final Pattern PATTERN = Pattern.compile(REG_EX);

    private ReportOfTimePeriods() {}

    public static void generateReport (Path pathOfOriginalLogFile, Path pathOfReport) throws IOException {
        Scanner scanner = new Scanner(pathOfOriginalLogFile);
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(pathOfReport, CREATE, APPEND)) {
            while (scanner.hasNextLine()) {
                    String prevLine;
                    do {
                        prevLine = scanner.nextLine();
                    } while (prevLine.isBlank());
                    while (scanner.hasNextLine()) {
                        String newLine = scanner.nextLine();
                        if (!newLine.isBlank()) {
                            Matcher matcher = PATTERN.matcher(newLine);
                            while (matcher.find()) {
                                String endTimeOfPrev = String.format("-%s ", matcher.group("time"));
                                String finalPrevLine = prevLine.replaceFirst(" ", endTimeOfPrev);
                                bufferedWriter.write(finalPrevLine + "\n");
                                prevLine = matcher.group();
                            }
                        } else {
                            bufferedWriter.write("\n");
                            break;
                        }
                    }
            }
        }
    }
}
