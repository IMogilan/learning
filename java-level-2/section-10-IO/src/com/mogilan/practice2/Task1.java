package com.mogilan.practice2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

/**1. Задан файл со стихотворением Александра Пушкина. Определить частоту повторяемости всех букв в стихотворении, игнорируя регистр.
 Вывести результат в файл в виде:
 а - 15
 б - 7
 ....
 я - 11*/

public class Task1 {
    public static void main(String[] args) throws IOException {
        Path pathOfSourceText = Path.of("src", "com", "mogilan", "practice2", "Task1SourceText.txt");
        Map <String, Integer> lettersMap = new TreeMap<String, Integer>();
        Files.newBufferedReader(pathOfSourceText).lines()
                .map(line -> line.split("\s"))
                .flatMap(Arrays::stream)
                .map(String::toLowerCase)
                .forEach(currentWord -> letterCounter(currentWord, lettersMap));
        List<String> resultText = lettersMap.entrySet().stream()
                .map(entry -> entry.getKey() + " - " + entry.getValue()).toList();

        Path pathOfResult = Path.of("src", "com", "mogilan", "practice2", "Task1Result.txt");
        Files.writeString(pathOfResult, resultText.toString());
    }

    public static void letterCounter (String currentWord, Map <String, Integer> lettersMap) {
        for (int i = 0; i < currentWord.length(); i++) {
            String currentLetter = String.valueOf(currentWord.charAt(i));
            String regEx = "[a-zA-Zа-яА-Я]";
            if (currentLetter.matches(regEx)) {
                int currentAmountOfSuchLetter = lettersMap.getOrDefault(currentLetter, 0);
                int newAmountOfSuchLetter = currentAmountOfSuchLetter + 1;
                lettersMap.put(currentLetter, newAmountOfSuchLetter);
            }
        }
    } 
}
