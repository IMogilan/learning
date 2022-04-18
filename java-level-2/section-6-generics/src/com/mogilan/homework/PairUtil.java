package com.mogilan.homework;

public final class PairUtil {

    private PairUtil () {}

    public static <K, V> Pair <V, K> swap ( Pair<K, V> pairInitial) {
       return new Pair<V, K>(pairInitial.getSecondParameter(), pairInitial.getFirstParameter());
    }

}
