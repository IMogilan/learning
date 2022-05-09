package com.mogilan.practice.dump;

import com.mogilan.practice.Detail;
import com.mogilan.practice.Night;

import static com.mogilan.practice.RobotProductionUtil.*;


public class FactoryDumpThread extends Thread {

    private final FactoryDump factoryDump;
    private final Night night;

    public FactoryDumpThread(FactoryDump factoryDump, Night night) {
        this.factoryDump = factoryDump;
        this.night = night;
    }

    @Override
    public void run() {
           int currentNightNumber = night.getCurrentNumber();
           while (currentNightNumber <= MAX_NUMBER_OF_DAYS) {
               long startTimeMillis = System.currentTimeMillis();
               int numberOfNewDetails = RANDOM.nextInt(MAX_NUMBER_OF_DETAILS_AT_ONE_DAY);
               for (int i = 0; i < numberOfNewDetails; i++) {
                   Detail newDetail = Detail.getRandomDetail();
                   synchronized (factoryDump) {
                       factoryDump.addNewDetail(newDetail);
                   }
                   System.out.println("Detail of Robot that was thrown into a factory dump: " + newDetail);
               }
               long finishTimeMillis = System.currentTimeMillis();
               sleepTillNextNight(startTimeMillis, finishTimeMillis, ONE_DAY_DURATION);
               currentNightNumber = night.getCurrentNumber();
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
