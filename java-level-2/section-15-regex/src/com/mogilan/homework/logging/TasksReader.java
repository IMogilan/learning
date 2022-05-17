package com.mogilan.homework.logging;

public class TasksReader implements Runnable {

    private final Tasks tasks;
    public static final int SLEEPING_DURATION_IN_SEC = 5;

    public TasksReader(Tasks tasks) {
        this.tasks = tasks;
    }

    @Override
    public void run() {
        while (!tasks.isFileEmpty()) {
            tasks.readNewTask();
            try {
                Thread.sleep(SLEEPING_DURATION_IN_SEC);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}