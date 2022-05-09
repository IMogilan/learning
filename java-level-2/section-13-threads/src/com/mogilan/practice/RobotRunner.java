package com.mogilan.practice;

import com.mogilan.practice.assistant.AssistantThread;
import com.mogilan.practice.dump.FactoryDump;
import com.mogilan.practice.dump.FactoryDumpThread;
import com.mogilan.practice.scientists.Scientist;
import com.mogilan.practice.scientists.ScientistThread;

public class RobotRunner {

    public static void main(String[] args) {
        Night night = new Night();
        FactoryDump factoryDump = new FactoryDump();
        FactoryDumpThread factoryDumpThread = new FactoryDumpThread(factoryDump, night);

        Scientist scientistOne = new Scientist();
        ScientistThread scientistOneThread = new ScientistThread(scientistOne, night);
        AssistantThread assistantOneThread = new AssistantThread(scientistOne, factoryDump);

        Scientist scientistTwo = new Scientist();
        ScientistThread scientistTwoThread = new ScientistThread(scientistTwo, night);
        AssistantThread assistantTwoThread = new AssistantThread(scientistTwo, factoryDump);

        night.start();
        night.setName("Night");
        factoryDumpThread.start();
        factoryDumpThread.setName("Factory");
        scientistOneThread.start();
        scientistOneThread.setName("ScientistOne");
        assistantOneThread.start();
        assistantOneThread.setName("AssistantOne");
        scientistTwoThread.start();
        scientistTwoThread.setName("ScientistTwo");
        assistantTwoThread.start();
        assistantTwoThread.setName("AssistantTwo");

        try {
            night.join();
            factoryDumpThread.join();
            scientistOneThread.join();
            assistantOneThread.join();
            scientistTwoThread.join();
            assistantTwoThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        RobotProductionUtil.compareNumberOfFinishedRobots(scientistOne, scientistTwo);

    }
}
