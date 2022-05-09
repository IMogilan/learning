package com.mogilan.practice.robot;

import com.mogilan.practice.Detail;

public class Robot {
    private static int idGenerator = 1;
    private int id;
    public static final int TOTAL_NUMBER_OF_DETAIL_IN_ROBOT = 9;
    private int currentNumberOfDetail;
    private Detail head;
    private Detail body;
    private Detail leftHand;
    private Detail rightHand;
    private Detail leftLeg;
    private Detail rightLeg;
    private Detail cpu;
    private Detail ram;
    private Detail hdd;


    public Robot() {
        id = idGenerator++;
        currentNumberOfDetail = 0;
    }

    public boolean isFinished () {
       return currentNumberOfDetail == TOTAL_NUMBER_OF_DETAIL_IN_ROBOT;
   }

    public boolean setHead(Detail head) {
        if (this.head == null) {
            this.head = head;
            currentNumberOfDetail++;
            return true;
        } else return false;
    }

    public boolean setBody(Detail body) {
        if (this.body == null) {
            this.body = body;
            currentNumberOfDetail++;
            return true;
        } else return false;
    }

    public boolean setLeftHand(Detail leftHand) {
        if (this.leftHand == null) {
            this.leftHand = leftHand;
            currentNumberOfDetail++;
            return true;
        } else return false;
    }

    public boolean setRightHand(Detail rightHand) {
        if (this.rightHand == null) {
            this.rightHand = rightHand;
            currentNumberOfDetail++;
            return true;
        } else return false;
    }

    public boolean setLeftLeg(Detail leftLeg) {
        if (this.leftLeg == null) {
            this.leftLeg = leftLeg;
            currentNumberOfDetail++;
            return true;
        } else return false;
    }

    public boolean setRightLeg(Detail rightLeg) {
        if (this.rightLeg == null) {
            this.rightLeg = rightLeg;
            currentNumberOfDetail++;
            return true;
        } else return false;
    }

    public boolean setCpu(Detail cpu) {
        if (this.cpu == null) {
            this.cpu = cpu;
            currentNumberOfDetail++;
            return true;
        } else return false;
    }

    public boolean setRam(Detail ram) {
        if (this.ram == null) {
            this.ram = ram;
            currentNumberOfDetail++;
            return true;
        } else return false;
    }

    public boolean setHdd(Detail hdd) {
        if (this.hdd == null) {
            this.hdd = hdd;
            currentNumberOfDetail++;
            return true;
        } else return false;
    }

}
