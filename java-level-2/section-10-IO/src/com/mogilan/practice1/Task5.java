package com.mogilan.practice1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

/**5. Задан файл с java-кодом. Прочитать текст программы из файла и
 записать в другой файл в обратном порядке символы каждой
 строки.*/

public class Task5 {
    public static void main(String[] args) throws IOException {
        Path pathOfOriginalClass = Path.of("src", "com", "mogilan", "practice1", "Task3.java");
        Path newPath = Path.of("src", "com", "mogilan", "practice1", "ReverseTask3.txt");
        String reverseTextOfTask3 = Files.readAllLines(pathOfOriginalClass).stream()
                .map(StringBuffer::new)
                .map(StringBuffer::reverse)
                .collect(Collectors.joining("\n"));
        Files.writeString(newPath, reverseTextOfTask3);
    }
}
