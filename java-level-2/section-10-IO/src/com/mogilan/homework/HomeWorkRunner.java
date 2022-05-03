package com.mogilan.homework;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static com.mogilan.homework.resources.HomeWorkUtil.*;

public class HomeWorkRunner {
    public static void main (String [] args) throws IOException {
        Path pathOfItemsName = Path.of("src", "com", "mogilan", "homework", "resources", "items-name.csv");
        Path pathOfItemsPrice = Path.of("src", "com", "mogilan", "homework", "resources", "items-price.csv");

        Map<Integer, String> mapOfIdAndNames = extractingOfFirstTwoParameters(pathOfItemsName);
        Map <Integer, String> mapOfIdAndPrice = extractingOfFirstTwoParameters(pathOfItemsPrice);

        Map<Integer, String> resultMap = mergeTwoMaps(mapOfIdAndNames, mapOfIdAndPrice);
        Path pathOfResult = Path.of("src", "com", "mogilan", "homework", "resources", "result.csv");
        printResultInFile (pathOfResult, resultMap);

        List<Integer> incorrectPosition = iDOfIncorrectPosition(mapOfIdAndNames, mapOfIdAndPrice, resultMap);
        Path pathOfErrors = Path.of("src", "com", "mogilan", "homework", "resources", "errors.csv");
        Files.writeString(pathOfErrors, incorrectPosition.toString(), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE);
    }
    





}
