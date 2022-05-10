package com.mogilan.homework;

public class Day extends Thread{

    int currentDayNumber = 0;
    public static final long ONE_DAY_DURATION = 100L;
    private volatile boolean isNotFinished = true;

    @Override
    public void run() {

        synchronized (this) {
            while (isNotFinished) {
                System.out.println("Day number " + currentDayNumber);
                currentDayNumber++;
                this.notifyAll();
                try {
                    this.wait(ONE_DAY_DURATION);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized int getCurrentDayNumber() {
        return currentDayNumber;
    }

    public synchronized boolean isNotFinished() {
        return isNotFinished;
    }

    public synchronized void setAsFinished() {
        isNotFinished = false;
    }
}
