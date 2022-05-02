package com.mogilan.practice1;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**3. Задан файл с текстом. В каждой строке найти и вывести
 наибольшее число цифр, идущих подряд.*/

public class Task3 {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("src", "com", "mogilan", "practice1", "fileNumbers.txt");

        //Option 1 (Scanner)
        System.out.print("Option 1 (Scanner): ");
        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNextLine()) {
                System.out.print(findMaxLengthOfNumber(scanner.nextLine()) + " ");
            }
        }
        System.out.println();

        //Option 2 (Files + Stream)
        System.out.print("Option 2 (Files + Stream): ");
        Files.readAllLines(path).stream()
                .map(Task3::findMaxLengthOfNumber)
                .forEach(string -> System.out.print(string + " "));
    }

    private static int findMaxLengthOfNumber(String nextLine) {
        int result = 0;
        String rexEx = "[\\d]+";
        Pattern pattern = Pattern.compile(rexEx);
        Matcher matcher = pattern.matcher(nextLine);
        while (matcher.find()) {
            String newNumber = matcher.group();
            if (newNumber.length() > result) result = newNumber.length();
        }
        return result;
    }
}
