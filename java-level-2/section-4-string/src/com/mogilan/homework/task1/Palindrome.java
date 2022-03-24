package com.mogilan.homework.task1;

/*1. Проверить, является ли введённая строка палиндромом, т.е. читается одинаково
 в обоих направлениях*/

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        String word = setWord();
        isPalindrome(word);
    }

    private static void isPalindrome(String word) {
        String wordWithoutSpase = word.replace(" ", "");
        String firstHalfOfTheWord = wordWithoutSpase.substring(0, wordWithoutSpase.length() / 2);
        int beginningOfSecondHalf = ((wordWithoutSpase.length() % 2 == 0) ? wordWithoutSpase.length() / 2: wordWithoutSpase.length() / 2 + 1);
        String secondHalfOfTheWord = wordWithoutSpase.substring(beginningOfSecondHalf, wordWithoutSpase.length());
        boolean isPalindrome = true;
        for (int i = 0, j = (secondHalfOfTheWord.length() - 1); i < firstHalfOfTheWord.length(); i++, j--) {
            if (firstHalfOfTheWord.charAt(i) != secondHalfOfTheWord.charAt(j)) isPalindrome = false;
        }
        System.out.print("The word is ");
        System.out.println(isPalindrome? "palindrome": "not palindrome");
    }

    private static String setWord() {
        boolean isCorrectValue = true;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter the Word: ");
            if (!scanner.hasNextLine()) {
                System.out.println("Incorrect value! Try again.");
                isCorrectValue = false;
            }
        } while (!isCorrectValue);
        return scanner.nextLine();
    }


}
