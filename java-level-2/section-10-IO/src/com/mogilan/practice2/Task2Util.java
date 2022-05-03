package com.mogilan.practice2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public final class Task2Util {

    private Task2Util() {}

    public static LinkedList<Integer> createNewListWithRandomNumbers(int capacity) {
        LinkedList<Integer> listOfInitialNumbers = new LinkedList<>();
        for (int i = 0; i < capacity; i++) {
            Integer newNumber = (int) (Math.random()*capacity + 1);
            listOfInitialNumbers.add(newNumber);
        }
        return listOfInitialNumbers;
    }

    public static void listToFile(Path pathOfResult, List<Integer> listOfInitialNumbers) throws IOException {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(pathOfResult,
                StandardOpenOption.APPEND, StandardOpenOption.CREATE)) {
            listOfInitialNumbers.stream()
                    .map(Object::toString)
                    .forEach(number -> {
                        try {
                            bufferedWriter.write(number);
                            bufferedWriter.newLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }

    public static void sortNumbersInFile(Path pathOfResult) throws IOException {
        List<Integer> sortedNumbers = Files.newBufferedReader(pathOfResult).lines()
                .map(line -> line.split("\s"))
                .flatMap(Arrays::stream)
                .map(Integer::valueOf)
                .sorted()
                .toList();
        Files.newBufferedWriter(pathOfResult).write("");
        Task2Util.listToFile(pathOfResult, sortedNumbers);
    }
}
