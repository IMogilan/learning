package com.mogilan.homework;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.nio.file.StandardOpenOption.*;

public class ReportWriter {

    private final Lock lock = new ReentrantLock();
    private final Path pathOfReport;

    public ReportWriter(Path pathOfReport) {
        this.pathOfReport = pathOfReport;
    }

    public void addToReport (String newLine) {
        try {
            Files.writeString(pathOfReport, newLine + "\n", APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Lock getLock() {
        return lock;
    }
}
