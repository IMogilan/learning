package com.mogilan.homework;

public class Pair<K, V> {
    private K firstParameter;
    private V secondParameter;

    public Pair (K firstParameter, V secondParameter) {
        this.firstParameter = firstParameter;
        this.secondParameter = secondParameter;
    }

    public K getFirstParameter () {
        return firstParameter;
    }

    public V getSecondParameter () {
        return secondParameter;
    }

    public void setFirstParameter (K firstParameter) {
        this.firstParameter = firstParameter;
    }

    public void setSecondParameter (V secondParameter) {
        this.secondParameter = secondParameter;
    }

    @Override
    public String toString () {
        return "Pair (firstParameter: " + getFirstParameter() + "; secondParameter: " + getSecondParameter() + ")";
    }

}
