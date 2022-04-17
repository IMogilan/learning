package com.mogilan.homework.task2;

public interface Massive {

    /**Метод сравнивает массы двух объектов.*/
    default long compareMass (AstronomicalObject astronomicalObject) {
        return  this.getMass() - astronomicalObject.getMass();
    }

    /**Метод возвращает массу объекта*/
    public long getMass();

    /**Метод проверяет, равны ли массы двух объектов друг другу с учетом допустимой погрешности (delta).
     * По умолчанию значение допустимой погрешности (delta) установлено в размере 0.00000000001*/
    default boolean isMassEqualsWithDelta (AstronomicalObject astronomicalObject) {
        double delta = 0.00000000001;
        return  Math.abs(this.getMass() - astronomicalObject.getMass()) < delta;
    }

}
