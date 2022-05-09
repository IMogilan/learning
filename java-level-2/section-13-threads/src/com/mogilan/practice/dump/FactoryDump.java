package com.mogilan.practice.dump;

import com.mogilan.practice.Detail;

import java.util.LinkedList;
import java.util.Queue;

public class FactoryDump {

    Queue <Detail> detailsAvailableOnFactoryDump = new LinkedList <> ();
    public static final int INITIAL_CAPACITY = 20;

    public FactoryDump() {
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            detailsAvailableOnFactoryDump.add(Detail.getRandomDetail());
        }
    }

    public synchronized void addNewDetail (Detail newDetail) {
        detailsAvailableOnFactoryDump.add(newDetail);
    }

    public synchronized Detail getDetail () {
        Detail removableDetail = detailsAvailableOnFactoryDump.remove();
        return removableDetail;
    }

    public synchronized boolean isEmpty () {
        return detailsAvailableOnFactoryDump.isEmpty();
    }

}
