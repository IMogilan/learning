package com.mogilan.practice2.task1;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class WordsUtil {
    private WordsUtil() {}

    public static Set<String> getUniqueWords (String text) {
        return new TreeSet<>(splitTextToList(text));
    }

    public static Map<String, Integer> frequencyOfWords (String text) {
//        Option 1. Created by myself
//        List<String> words = splitText(text);
//        List<String> uniqueWords = new ArrayList<>(getUniqueWords(text));
//        Map<String, Integer> result = new LinkedHashMap<>();
//        for (int i = 0; i < uniqueWords.size(); i++) {
//            String currentKey = uniqueWords.get(i);
//            int numberOfMatches = 0;
//            for (String word : words) {
//                if (currentKey.equals(word)) numberOfMatches++;
//            }
//            result.put(currentKey, numberOfMatches);
//        }
//        return result;

        /* Option 2. Much better! Based on the lecturer's idea*/
        List<String> words = splitTextToList(text);
        Map<String, Integer> result = new LinkedHashMap<>();
        for (String word : words) {
            Integer currentNumber = result.get(word);
            Integer newNumber = currentNumber == null ? 1 : currentNumber + 1;
            result.put(word, newNumber);
        }
        return result;
    }

    public static List<String> splitTextToList(String text) {
        List<String> words = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) words.add(matcher.group());
        return words;
    }
    // Метод splitTextToArray был добавлен в программу просто для тренировки регулярных выражений. Данный метод можно было использовать в программе
    // вместо метода splitTextToList.
    public static String [] splitTextToArray (String text) {
        return text.replaceAll("\\p{Punct}", " ").replaceAll("\\s+", " ").split("\\s");
    }
}
