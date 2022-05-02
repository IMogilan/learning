package com.mogilan.practice1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task1 {
    /**
     * 1. Задан файл с текстом, найти и вывести в консоль все слова,
     * начинающиеся с гласной буквы.
     */

    public static final String REG_EX = "[aeiouyAEIOUYаеёиоуэюяАЕЁИОУЭЮЯ]{1}[a-zA-Zа-яА-Я]*";

    public static void main(String[] args) throws IOException {

        // Option 1
        System.out.println("Option 1:");
        File textFile = Path.of("src", "com", "mogilan", "practice1", "textFile.txt").toFile();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(textFile))) {
            String result = bufferedReader.lines()
                    .map(allLines -> allLines.split("\s"))
                    .flatMap(Arrays::stream)
                    .filter(separateWords -> separateWords.matches(REG_EX))
                    .collect(Collectors.joining(" "));
            System.out.println(result);
        }

        //Option 2
        System.out.println("Option 2:");
        Path path = Path.of("src", "com", "mogilan", "practice1", "textFile.txt");
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            String result = bufferedReader.lines()
                    .map(allLines -> allLines.split("\s"))
                    .flatMap(Arrays::stream)
                    .filter(separateWords -> separateWords.matches(REG_EX))
                    .collect(Collectors.joining(" "));
            System.out.println(result);
        }

        //Option 3
        System.out.println("Option 3:");
        Path path2 = Path.of("src", "com", "mogilan", "practice1", "textFile.txt");
        try (Scanner scanner = new Scanner(path2)) {
            while (scanner.hasNext()) {
                String next = scanner.next();
                if (next.matches(REG_EX)) {
                    System.out.print(next + " ");
                }
            }
        }


    }

}

