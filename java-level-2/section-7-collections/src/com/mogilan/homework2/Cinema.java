package com.mogilan.homework2;
/*Домашнее задание
1. Даны 2 класса:
- Фильм с 5-ю полями: Уникальный Целочисленный идентификатор (id), Год издания, Месяц издания, Жанр и Рейтинг;
- Кинотеатр, где есть всего лишь одно единственное поле: отсортированный ассоциативный массив, где ключом является
 год издания, а значением - все фильмы, выпустившиеся в этом году.

Добавить функционал в кинотеатр таким образом, чтобы можно было:
- добавлять в него новый фильм
- получить все фильмы по переданному году
- получить все фильмы по переданному году и месяцу
- получить все фильмы по переданному жанру
- получать ТОП-10 фильмов отсортированные по Рейтингу в порядке убывания

Учесть следующее:
- в кинотеатре фильмы должны храниться в порядке их добавления в него (т.е. предусмотреть порядок
значения ассоциативного массива)
- не должен добавляться фильм, если такой уже есть в кинотеатре

Продемонстрировать работу кинотеатра в отдельном классе*/

import java.util.*;

public class Cinema {

    Map<Integer, Set<Film>> allFilmsInCinema;
    private static final int NUMBER_OF_TOP_FILMS = 10;

    public Cinema() {
        this.allFilmsInCinema = new TreeMap<>();
    }

    public boolean addNewFilm (Film film) {
        boolean isAdded = true;
        if (allFilmsInCinema.get(film.yearOfProduction) != null) {
            Set <Film> currentSetOfFilms = allFilmsInCinema.get(film.yearOfProduction);
            isAdded = currentSetOfFilms.add(film);
        } else {
            Set<Film> newfilmsSet = new LinkedHashSet<>();
            newfilmsSet.add(film);
            allFilmsInCinema.put(film.yearOfProduction, newfilmsSet);
        }
        return isAdded;
    }

    public boolean addListOfFilms (List<Film> listOfFilms) {
        boolean isAllAdded = true;
        for (Film currentFilm : listOfFilms) {
            boolean isAdded = addNewFilm(currentFilm);
            if (!isAdded) isAllAdded = false;
        }
        return isAllAdded;
    }

    public Set<Film> getFilmOfSettledByYear(int year) {
        return allFilmsInCinema.getOrDefault(year, null);
    }

    public Set<Film> getFilmOfSettledByMonth(MonthOfProduction month) {
       Set <Film> result = new LinkedHashSet <> ();
       if (!allFilmsInCinema.isEmpty())  {
           for (Set<Film> filmSet : allFilmsInCinema.values()) {
               for (Film film : filmSet) {
                   if (film.getMonthofProduction().equals(month)) result.add(film);
               }
           }
           return result;
       } else return null;
    }

    public Set<Film> getFilmOfSettledByYearAndMonth (int year, MonthOfProduction month) {
        Set <Film> yearResults = allFilmsInCinema.getOrDefault(year, null);
        if (yearResults != null && !yearResults.isEmpty())  {
            Set <Film> result = new LinkedHashSet <> ();
            for (Film film : yearResults) {
                if (film.getMonthofProduction().equals(month)) result.add(film);
            }
            return result;
        } else return null;
    }

    public Set<Film> getFilmOfSettledByGenre (Genre genre) {
        Set <Film> result = new LinkedHashSet <> ();
        if (!allFilmsInCinema.isEmpty()) {
            for (Set<Film> filmSet : allFilmsInCinema.values()) {
                for (Film film : filmSet) {
                    if (film.getGenre().equals(genre)) result.add(film);
                }
            }
            return result;
        } else return null;
    }
//    Option 1 (by using of Arraylist methods)
//    public List <Film> getTopTenFilmsByRating (){
//        List<Film> result = new ArrayList<>();
//        for (Set<Film> setsOfFilmsByYear : allFilmsInCinema.values()) {
//            for (Film film : setsOfFilmsByYear) {
//                result.add(film);
//            }
//        }
//        if (result != null && !result.isEmpty()) {
//            result.sort(new RatingFilmComparator().reversed());
//            int finish = Math.min(NUMBER_OF_TOP_FILMS, result.size());
//            return result.subList(0, finish);
//        } else return null;
//    }

    // Option 2 (by using Set particular qualities)
    public Set <Film> getTopTenFilmsByRating (){
        Set <Film> sortedSetOfFilms = new TreeSet<>(new FilmComparator().reversed());
        for (Set<Film> setsOfFilmsByYear : allFilmsInCinema.values()) {
            for (Film film : setsOfFilmsByYear) {
                sortedSetOfFilms.add(film);
            }
        }
        if (sortedSetOfFilms != null && !sortedSetOfFilms.isEmpty()) {
            int counter = 0;
            int finish = Math.min(NUMBER_OF_TOP_FILMS, sortedSetOfFilms.size());
            Set <Film> result = new LinkedHashSet<>();
            for (Film film : sortedSetOfFilms) {
                result.add(film);
                counter++;
                if (counter == finish) break;
            }
            return result;
        } else return null;
    }

    @Override
    public String toString() {
        return "Cinema{\n" +
                "films=" + allFilmsInCinema +
                '}';
    }
}

