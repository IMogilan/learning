package com.mogilan.practice.scientists;

import com.mogilan.practice.Detail;
import com.mogilan.practice.robot.Robot;
import java.util.*;
import static com.mogilan.practice.Detail.*;

public class Scientist {

    private final int id;
    private static int idGenerator = 1;
    private final Queue <Detail> listOfDetails = new LinkedList<>();
    private final List <Robot> listOfRobots = new ArrayList<>();
    Map <Detail, Integer> mapIndexOfEachDetail = new HashMap<>(Map.of(
            HEAD, 0,
            BODY, 0,
            LEFT_HAND, 0,
            RIGHT_HAND, 0,
            LEFT_LEG, 0,
            RIGHT_LEG, 0,
            CPU, 0,
            RAM,0,
            HDD, 0
    ));

    public Scientist() {
       this.id = idGenerator++;
       listOfRobots.add(new Robot());
    }

    public int getAndIncrementCurrentIndexOfDetail (Detail newDetail) {
        synchronized (this) {
            int currentIndex = mapIndexOfEachDetail.get(newDetail);
            int newIndex = currentIndex + 1;
            mapIndexOfEachDetail.replace(newDetail, newIndex);
            return currentIndex;
        }
    }

    public synchronized void setDetailOnRobot (Detail detail, int indexOfRobot) {
        Robot currentRobot = listOfRobots.get(indexOfRobot);
        switch (detail) {
            case HEAD -> currentRobot.setHead(detail);
            case BODY -> currentRobot.setBody(detail);
            case LEFT_HAND -> currentRobot.setLeftHand(detail);
            case RIGHT_HAND -> currentRobot.setRightHand(detail);
            case LEFT_LEG -> currentRobot.setLeftLeg(detail);
            case  RIGHT_LEG -> currentRobot.setRightLeg(detail);
            case  CPU -> currentRobot.setCpu(detail);
            case  RAM -> currentRobot.setRam(detail);
            case  HDD -> currentRobot.setHdd(detail);
        }
    }

    public synchronized int getCurrentNumberOfManufacturingRobots () {
        return listOfRobots.size();
    }

    public synchronized boolean isListOfDetailsEmpty () {
        return listOfDetails.isEmpty();
    }

    public synchronized void addNewDetail (Detail newDetail) {
        listOfDetails.add(newDetail);
    }

    public synchronized Detail getDetail () {
        Detail removableDetail = listOfDetails.remove();
        return removableDetail;
    }

    public synchronized void addNewRobot () {
        listOfRobots.add(new Robot());
    }

    public int getId() {
        return id;
    }

    public List<Robot> getListOfRobots() {
        return listOfRobots;
    }

    public long numberOfFinishedRobots () {
       return listOfRobots.stream()
                .filter(Robot::isFinished)
                .count();
    }
}
