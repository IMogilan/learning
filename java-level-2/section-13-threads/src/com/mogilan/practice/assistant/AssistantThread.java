package com.mogilan.practice.assistant;

import com.mogilan.practice.Detail;
import com.mogilan.practice.dump.FactoryDump;
import com.mogilan.practice.scientists.Scientist;
import java.util.LinkedList;
import java.util.Queue;

import static com.mogilan.practice.RobotProductionUtil.*;

public class AssistantThread extends Thread {

    private int currentDayNumber = 1;
    private double id;
    private static double idGenerator = 1;
    private Scientist scientist;
    private FactoryDump factoryDump;
    private Queue<Detail> detailsCarryingBYAssistant;

    public AssistantThread(Scientist scientist, FactoryDump factoryDump) {
        this.id = scientist.getId() + idGenerator++ * ((1 / (double) MAX_NUMBER_OF_ASSISTANCE_FOR_ONE_SCIENTIST));
        this.scientist = scientist;
        this.factoryDump = factoryDump;
        this.detailsCarryingBYAssistant = new LinkedList<>();
    }

    @Override
    public void run() {
               while (currentDayNumber <= MAX_NUMBER_OF_DAYS) {
                   currentDayNumber++;
                   long startTimeMillis = System.currentTimeMillis();
                   takeDetailsOnFactoryDump();
                   gaveDetailsToScientist();
                   long finishTimeMillis = System.currentTimeMillis();
                   sleepTillNextNight(startTimeMillis, finishTimeMillis, ONE_DAY_DURATION);
               }

    }

    private void takeDetailsOnFactoryDump () {
        int numberOfNewDetails = RANDOM.nextInt(MAX_NUMBER_OF_DETAILS_AT_ONE_DAY);
        for (int i = 0; i < numberOfNewDetails; i++) {
            Detail currentDetail;
                synchronized (factoryDump) {
                     if (!factoryDump.isEmpty()) {
                        currentDetail = factoryDump.getDetail();
                        System.out.println("Assistant " + id + " get detail " + currentDetail);
                    } else {
                        System.out.println("Assistant " + id + " waits because the factory dump was empty");
                        continue;
                    }
                }
            detailsCarryingBYAssistant.add(currentDetail);
        }
    }

    private void gaveDetailsToScientist () {
        while (!detailsCarryingBYAssistant.isEmpty()) {
            Detail currentDetail = detailsCarryingBYAssistant.remove();
            synchronized (scientist) {
                scientist.addNewDetail(currentDetail);
                System.out.println("Assistant " + id + " gave to scientist " + scientist.getId() + " detail " + currentDetail);
            }
        }
    }

    private void sleepTillNextNight (long startTimeMillis, long finishTimeMillis, long oneDayDuration) {
        long timeSpentByAssistant = finishTimeMillis - startTimeMillis;
        try {
            Thread.sleep(Math.max(oneDayDuration - timeSpentByAssistant, 1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
