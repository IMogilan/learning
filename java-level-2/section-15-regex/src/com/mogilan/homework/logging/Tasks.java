package com.mogilan.homework.logging;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tasks {

    private final Scanner scannerTasks;
    private BlockingQueue<String> queueOfTasks = new LinkedBlockingQueue<>();
    private final Lock lock = new ReentrantLock();
    private boolean isEmpty = false;
    private boolean isFileEmpty = false;

    public Tasks(Path path) throws IOException {
        this.scannerTasks = new Scanner(path);
    }

    public synchronized void readNewTask() {
        if (scannerTasks.hasNextLine()) {
            queueOfTasks.add(scannerTasks.nextLine());
        } else {
            isFileEmpty = true;
        }
    }

    public synchronized Optional<String> removeTask() {
       if (!queueOfTasks.isEmpty()) {
           return Optional.ofNullable(queueOfTasks.remove());
       }  else {
//           if(isFileEmpty) isEmpty = true;
           return Optional.empty();
       }
    }

    public Lock getLock() {
        return lock;
    }

    public synchronized boolean isEmpty() {
        return isFileEmpty && queueOfTasks.isEmpty();
    }

    public boolean isFileEmpty() {
        return isFileEmpty;
    }

}
