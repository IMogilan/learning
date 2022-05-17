package com.mogilan.homework.logging;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;

import static com.mogilan.homework.util.ServiceUtil.*;

/**Все жалобы клиентов хранятся в хронологическом порядке в виде текстового лог-файла
 * следующего формата (столбцы разделены через запятую):
 - Порядковый номер клиента
 - Дата и время звонка в ISO формате
 - Фамилия и Имя клиента
 - Телефон клиента
 - Текст жалобы
 Каждая новая жалоба идет с новой строки в лог-файле.
 */
public class TaskCreator {

    private static int currentNumber = 22;

    public void andTask (Path path, int numberOfNewTasks) {
        Scanner scanner = new Scanner(System.in);
        int current = 1;
        while (current++ <= numberOfNewTasks) {
            System.out.println("Введите через запятую свои данные: фамилию и имя, номер телефона и текст жалобы.\n" +
                    "Например: Иванов Иван, + 375 (29) 111 11 11, Сломался компьютер\n" +
                    "После чего нажмите Enter");
            if (scanner.hasNextLine()) {
                String lineOfTask = scanner.nextLine();
                if (!lineOfTask.isBlank()) {
                    Matcher matcher = PATTERN.matcher(lineOfTask);
                    if (matcher.find()) {
                        printToFile(path, matcher.group(INITIALS), matcher.group(FULL_TEL_NUMBER), matcher.group(TASK));
                    } else {
                        System.out.println("Введены некорректные данные. Попробуйте еще раз.");
                        current--;
                        break;
                    }
                } else {
                    System.out.println("Введены некорректные данные. Попробуйте еще раз.");
                    current--;
                    break;
                }
            }
        }
    }

//    private int numberOfNewTasks() {
//        int numberOfNewTasks = 0;
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите количество новых задач и введите Enter");
//        if(scanner.hasNextInt()) numberOfNewTasks = scanner.nextInt();
//        return numberOfNewTasks;
//    }

    private void printToFile (Path path, String initials, String telNumber, String task) {
        DateTimeFormatter delimetr = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        String time = LocalDateTime.now().format(delimetr);
        String newTask = String.format("%d, %s, %s, %s, %s\n", currentNumber++, time, initials, telNumber, task);
        try {
            Files.writeString(path, newTask, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
