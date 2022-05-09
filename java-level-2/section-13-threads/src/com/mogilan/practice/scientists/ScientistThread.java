package com.mogilan.practice.scientists;

import com.mogilan.practice.Detail;
import com.mogilan.practice.Night;
import com.mogilan.practice.dump.FactoryDump;

import static com.mogilan.practice.RobotProductionUtil.MAX_NUMBER_OF_DAYS;

public class ScientistThread extends Thread {

    private final Scientist scientist;
    private final Night night;

    public ScientistThread(Scientist scientist, Night night) {
        this.scientist = scientist;
        this.night = night;
    }

    @Override
    public void run() {
            int currentNightNumber = night.getCurrentNumber();
            while (currentNightNumber <= MAX_NUMBER_OF_DAYS) {
                currentNightNumber = night.getCurrentNumber();
                Detail currentDetail;
                synchronized (scientist) {
                    if (!scientist.isListOfDetailsEmpty()) currentDetail = scientist.getDetail();
                    else continue;
                    int currentDetailIndex = scientist.getAndIncrementCurrentIndexOfDetail(currentDetail);
                    if (currentDetailIndex < scientist.getCurrentNumberOfManufacturingRobots()) scientist.addNewRobot();
                    scientist.setDetailOnRobot(currentDetail, currentDetailIndex);
                    System.out.println("Scientist " + scientist.getId() + " set on robot number " + currentDetailIndex + " detail " + currentDetail);
                }
                System.out.println("Scientist " + scientist.getId() + " has finished " + scientist.numberOfFinishedRobots() + " robots");
                try {
                    Thread.sleep(5L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

