package com.mogilan.practice;

import com.mogilan.practice.scientists.Scientist;

import java.util.Random;

public final class RobotProductionUtil {

    private RobotProductionUtil() {}

    public static void compareNumberOfFinishedRobots (Scientist scientistOne, Scientist scientistTwo) {
        long result = scientistOne.numberOfFinishedRobots() - scientistTwo.numberOfFinishedRobots();
        if ( result > 0) {
            System.out.println("Scientist " + scientistOne.getId() + " has created robots on " + result +
                    " more than scientist " + scientistTwo.getId());
        } else if ( result < 0) {
            System.out.println("Scientist " + scientistTwo.getId() + " has created robots on " + Math.abs(result) +
                    " more than scientist " + scientistOne.getId());
        } else {
            System.out.println("Scientist " + scientistTwo.getId() + " and scientist " + scientistTwo.getId() +
                    " have created the same number of robots (" + scientistOne.numberOfFinishedRobots() +")");
        }
    }

    public static final long ONE_DAY_DURATION = 100L;

    public static final int MAX_NUMBER_OF_DAYS = 100;

    public static final int MAX_NUMBER_OF_DETAILS_AT_ONE_DAY = 4;

    public static final Random RANDOM = new Random();

    public static final int MAX_NUMBER_OF_ASSISTANCE_FOR_ONE_SCIENTIST = 100;
}
