package com.mogilan.practice;

import static com.mogilan.practice.RobotProductionUtil.MAX_NUMBER_OF_DAYS;

public class Night extends Thread {

    private int currentNumber = 1;

    @Override
    public void run() {
        synchronized (this) {
            while (currentNumber <= MAX_NUMBER_OF_DAYS) {
                System.out.println("Night number " + currentNumber);
                currentNumber++;
                try {
                    this.notifyAll();
                    this.wait(RobotProductionUtil.ONE_DAY_DURATION);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized int getCurrentNumber() {
        return currentNumber;
    }
}
