package com.mogilan.homework;

public class HomeWorkRunner {
    public static void main(String[] args) {
        Pair<String, Integer>  firstPair = new Pair<>("FirstParameter", Integer.valueOf("2"));
        Pair <Integer, String> swappedPair = PairUtil.swap(firstPair);
        System.out.println(swappedPair);
    }
}
