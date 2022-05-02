package com.mogilan.practice1;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

/**2. Задан файл с текстом, найти и вывести в консоль все слова,  для
 которых последняя буква одного слова совпадает с первой буквой
 следующего слова*/

public class Task2 {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("src", "com", "mogilan", "practice1", "textFile.txt");
        try (Scanner scanner = new Scanner(path)) {
            String previousWord = "";
            while (scanner.hasNext()) {
                String currentWord = scanner.next();
                String firstLetterOfCurrentWord = String.valueOf(currentWord.charAt(0));
                if (previousWord.endsWith(firstLetterOfCurrentWord)) {
                    System.out.println(previousWord + " " + currentWord);
                }
                previousWord = currentWord;
            }
        }
    }
}
