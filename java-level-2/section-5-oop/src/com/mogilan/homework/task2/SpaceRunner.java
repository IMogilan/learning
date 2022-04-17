package com.mogilan.homework.task2;

public class SpaceRunner {

    public static void main(String[] args) {
        Planet Earth = new Planet("Земля", 1111111 , 2222222 ,3333333333L );
        Star Sun = new Star("Солнце", 9999999999999L, 9999999999999L);
        System.out.println(SpaceUtils.forceOfGravity(Sun, Earth, 132213311));
        System.out.println(Earth.compareMass(Sun));
        System.out.println(Earth);
    }
}
