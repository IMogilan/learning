package com.mogilan.practice2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**2. Создать программно и заполнить файл случайными целыми числами.
 После чего отсортировать содержимое файла по возрастанию (т.е. перезаписать файл с новым порядком чисел)*/

public class Task2 {
    public static final int CAPACITY = 100;

    public static void main(String[] args) throws IOException {
        Path pathOfResult = Path.of("src", "com", "mogilan", "practice2", "Task2Result.txt");
        LinkedList<Integer> listOfInitialNumbers = Task2Util.createNewListWithRandomNumbers(CAPACITY);
        Task2Util.listToFile (pathOfResult, listOfInitialNumbers);
        Task2Util.sortNumbersInFile(pathOfResult);
    }


}
