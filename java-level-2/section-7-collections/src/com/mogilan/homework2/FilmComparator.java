package com.mogilan.homework2;

import java.util.Comparator;

public class FilmComparator implements Comparator<Film> {
    @Override
    public int compare(Film o1, Film o2) {
        if (Double.compare(o1.getRating(), o2.getRating()) != 0) return Double.compare(o1.getRating(), o2.getRating());
          else return - (Integer.compare(o1.getId(), o2.getId()));
    }

}
