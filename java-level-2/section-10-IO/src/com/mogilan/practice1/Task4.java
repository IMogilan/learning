package com.mogilan.practice1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**4. Задан файл с java-кодом. Прочитать текст программы из файла и
 все слова public в объявлении атрибутов и методов класса заменить
 на слово private. Результат сохранить в другой заранее созданный
 файл.*/

public class Task4 {
    public static void main(String[] args) throws IOException {
        Path pathOfOriginalClass = Path.of("src", "com", "mogilan", "practice1", "Task3.java");
        String originalClass = Files.readString(pathOfOriginalClass);
        String privateCopyOfTask3 = originalClass.replace("public", "private");

        Path pathOfPrivateCopyOfTask3 = Path.of("src", "com", "mogilan", "practice1", "PrivateCopyOfTask3.txt");
        Files.writeString(pathOfPrivateCopyOfTask3,privateCopyOfTask3);
    }
}
