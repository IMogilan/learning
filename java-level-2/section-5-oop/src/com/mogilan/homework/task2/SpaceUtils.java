package com.mogilan.homework.task2;

public final class SpaceUtils {

    private SpaceUtils() {
    }

    public static double forceOfGravity(AstronomicalObject objectOne, AstronomicalObject objectTwo, long distanceBetweenObjects) {
        long distance = distanceBetweenObjects - (objectOne.getDiameter() / 2) - (objectTwo.getDiameter() / 2);
        return 6.6743015E-11 * ((objectOne.getMass() + objectTwo.getMass()) / (Math.pow(distance, 2)));
    }

    public static boolean isStar (Object obj) {
        if (obj != null) return obj instanceof Star;
        else return false;
    }

}
