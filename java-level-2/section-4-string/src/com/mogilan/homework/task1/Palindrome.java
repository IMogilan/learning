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
        String firstHalfOfTheWord = word.substring(0, word.length() / 2);
        int beginningOfSecondHalf = ((word.length() % 2 == 0) ? word.length() / 2: word.length() / 2 + 1);
        String secondHalfOfTheWord = word.substring(beginningOfSecondHalf, word.length());
        boolean isPalindrome = true;
        for (int i = 0, j = (secondHalfOfTheWord.length() - 1); i < firstHalfOfTheWord.length(); i++, j--) {
            if (firstHalfOfTheWord.charAt(i) != secondHalfOfTheWord.charAt(j)) isPalindrome = false;
        }
        System.out.print("The word is ");
        System.out.println(isPalindrome? "palindrome": "not palindrome");
    }

    private static String setWord() {
        boolean inCorrectValue = true;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter the Word: ");
            if (!scanner.hasNext()) {
                System.out.println("Incorrect value! Try again.");
                inCorrectValue = false;
            }
        } while (!inCorrectValue);
        return scanner.next();
    }


}
