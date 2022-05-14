package com.mogilan.practice;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Day extends Thread{

    private Lock dayLock = new ReentrantLock();
    private AtomicInteger currentDayNumber = new AtomicInteger(0);
    public static final long ONE_DAY_DURATION = 50L;
    private AtomicBoolean isNotFinished = new AtomicBoolean(true);

    @Override
    public void run() {
        while (isNotFinished.get()) {
            lockDay();
            System.out.println("Day number " + currentDayNumber.getAndIncrement());
            dayLock.unlock();
            try {
                Thread.sleep(ONE_DAY_DURATION);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isNotFinished() {
        return isNotFinished.get();
    }

    public void setAsFinished() {
        isNotFinished.set(false);
    }

    public Lock getDayLock() {
        return dayLock;
    }

    public void lockDay () {
        boolean isLocked = false;
        while (!isLocked) {
            isLocked = dayLock.tryLock();
        }
    }

    public int getCurrentDayNumber() {
        return currentDayNumber.get();
    }
}
