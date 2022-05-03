package com.mogilan.homework.resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class HomeWorkUtil {

    private HomeWorkUtil() {}

    public static Map<Integer, String> extractingOfFirstTwoParameters(Path path) throws IOException {
        Map<Integer, String> resultMap;
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            resultMap = bufferedReader.lines()
                    .map(String::trim)
                    .filter(line -> line.length() > 0)
                    .filter(line -> (Character.isDigit(line.charAt(0))))
                    .distinct()
                    .map(line -> line.split(","))
                    .filter(stringArray -> stringArray[0].matches("\\d+"))
                    .collect(Collectors.toMap(array -> Integer.valueOf(array[0]),
                                              array -> array.length > 1 && !array[1].isBlank() ?
                                                      array[1] : ""));
        }
        return new TreeMap<>(resultMap);
    }

    public static List<Integer> iDOfIncorrectPosition (Map<Integer, String> firstMap, Map<Integer, String> secondMap, Map<Integer, String> resultMap) {
        firstMap.keySet().removeAll(resultMap.keySet());
        secondMap.keySet().removeAll(resultMap.keySet());
        TreeSet<Integer> allIdOfIncorrectPosition = new TreeSet<Integer>();
        allIdOfIncorrectPosition.addAll(firstMap.keySet());
        allIdOfIncorrectPosition.addAll(secondMap.keySet());
        List<Integer> uniqueIdOfIncorrectPositions = allIdOfIncorrectPosition.stream()
                .distinct()
                .toList();
        return uniqueIdOfIncorrectPositions;
    }

    public static Map<Integer, String> mergeTwoMaps (Map<Integer, String> firstMap, Map<Integer, String> secondMap) {
        Map<Integer, String> resultMap = new TreeMap<>();
        for (Map.Entry<Integer, String> entry : firstMap.entrySet()) {
            Integer currentKey = entry.getKey();
            String currentValue = entry.getValue();
            if ((!currentValue.isBlank()) && (secondMap.get(currentKey)) != null && (!secondMap.get(currentKey).isBlank())) {
                String newValue = currentValue + ", " + secondMap.get(currentKey);
                resultMap.put(currentKey, newValue);
            } else resultMap.remove(currentKey);
        }
        return resultMap;
    }

    public static void printResultInFile (Path pathOfResult, Map<Integer, String> resultMap) throws IOException {
        Files.writeString(pathOfResult, "ID,NAME,PRICE\n", StandardOpenOption.TRUNCATE_EXISTING);
        try (Stream<Map.Entry<Integer, String>> entryStream = resultMap.entrySet().stream()) {
            entryStream.forEach(entry -> {
                try {
                    Files.writeString(pathOfResult, entry.getKey() + ", " + entry.getValue() + "\n", StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }


}
