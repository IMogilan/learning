package com.mogilan.practice;

import java.util.Random;

import static com.mogilan.practice.RobotProductionUtil.*;

public enum Detail {
    HEAD,
    BODY,
    LEFT_HAND,
    RIGHT_HAND,
    LEFT_LEG,
    RIGHT_LEG,
    CPU,
    RAM,
    HDD;

    private static final Detail [] ALL_DETAILS_TYPE = Detail.values();

    public static Detail getRandomDetail () {
        return ALL_DETAILS_TYPE[RANDOM.nextInt(Detail.ALL_DETAILS_TYPE.length)];
    }
}
