package com.mogilan.homework;

import java.util.Random;

public enum Crystal {
    RED,
    WHITE;

    private final static Random RANDOM = new Random();

    public static Crystal createRandomCrystal () {
        return RANDOM.nextInt(2) == 0 ?  Crystal.RED :  Crystal.WHITE;
    }}
