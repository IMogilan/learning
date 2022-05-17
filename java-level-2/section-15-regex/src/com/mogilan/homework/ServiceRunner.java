package com.mogilan.homework;

import com.mogilan.homework.logging.TaskCreator;
import com.mogilan.homework.logging.Tasks;
import com.mogilan.homework.logging.TasksReader;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ServiceRunner {

    public static final int numberOfNewTasks = 0;

    public static void main(String[] args) throws IOException {
        Path pathOfLog = Path.of("src", "com", "mogilan", "homework", "resources", "log-file.txt");
        TaskCreator logFileRunner = new TaskCreator();
        logFileRunner.andTask(pathOfLog, numberOfNewTasks);

        Tasks tasks = new Tasks(pathOfLog);

        Path pathOfReport = Path.of("src", "com", "mogilan", "homework", "resources", "report.txt");
        ReportWriter reportWriter = new ReportWriter(pathOfReport);

        List<Thread> collect = Stream.of(
                        new TasksReader(tasks),
                        new OperatorOfService(tasks, reportWriter),
                        new OperatorOfService(tasks, reportWriter)
                ).map(Thread::new)
                .peek(Thread::start)
                .collect(Collectors.toList());
    }
}
