package com.mogilan.homework2;

import java.util.Comparator;

public class RatingFilmComparator implements Comparator <Film> {
    @Override
    public int compare(Film o1, Film o2) {
        return Double.compare(o1.getRating(), o2.getRating());
    }
}
