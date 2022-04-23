package com.mogilan.homework2;

import java.util.Comparator;
import java.util.Objects;

public class Film {

    final int id;
    final int yearOfProduction;
    final MonthOfProduction monthofProduction;
    final private Genre genre;
    private double rating;

    public Film(int id, int yearOfProduction, MonthOfProduction monthofProduction, Genre genre, double rating) {
        this.id = id;
        this.yearOfProduction = yearOfProduction;
        this.monthofProduction = monthofProduction;
        this.genre = genre;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public MonthOfProduction getMonthofProduction() {
        return monthofProduction;
    }

    public Genre getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", yearOfProduction=" + yearOfProduction +
                ", monthofProduction=" + monthofProduction +
                ", genre=" + genre +
                ", rating=" + rating +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return getId() == film.getId() && getYearOfProduction() == film.getYearOfProduction() && getMonthofProduction() == film.getMonthofProduction() && Double.compare(film.getRating(), getRating()) == 0 && getGenre() == film.getGenre();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getYearOfProduction(), getMonthofProduction(), getGenre(), getRating());
    }
}
