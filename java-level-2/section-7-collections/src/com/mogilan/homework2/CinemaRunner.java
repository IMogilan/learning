package com.mogilan.homework2;

import com.mogilan.practice2.task2.Garage;

import java.util.List;

public class CinemaRunner {
    public static void main(String[] args) {

        Film shawshankRedemption = new Film(1, 1994, MonthOfProduction.September, Genre.Drama, 9.3);
        Film godfather = new Film(2, 1972, MonthOfProduction.March, Genre.Drama, 9.2);
        Film darkKnight = new Film(3, 2008, MonthOfProduction.July, Genre.Action, 9.0);
        Film godfatherPartTwo = new Film(4, 1974, MonthOfProduction.December, Genre.Drama, 9.0);
        Film lordOfTheRingsTheReturnOfTheKing = new Film(7, 2003, MonthOfProduction.December, Genre.Fantasy, 9.0);
        Film forrestGump = new Film(11, 1994, MonthOfProduction.July, Genre.Drama, 8.8);
        Film starWarsV = new Film(15, 1980, MonthOfProduction.May, Genre.Fantasy, 8.7);
        Film starWarsIV = new Film(27, 1977, MonthOfProduction.May, Genre.Fantasy, 8.6);
        Film leon = new Film(34, 1994, MonthOfProduction.September, Genre.Drama, 8.5);
        Film walle = new Film(57, 2008, MonthOfProduction.June, Genre.Fantasy, 8.4);

        System.out.println("Проверка корректности работы метода addListOfFilms");
        List<Film> allFilms = List.of(shawshankRedemption, godfather, darkKnight, godfatherPartTwo, lordOfTheRingsTheReturnOfTheKing, forrestGump, starWarsV, starWarsIV, leon, walle);
        Cinema cinema = new Cinema();
        System.out.println("Все фильмы были помещены в кинотеатр (true/false): " + cinema.addListOfFilms(allFilms));
        System.out.println(cinema);

//        System.out.println("Проверка корректности работы метода addListOfFilms в случае, если повторно появляются уже ранее добавленные фильмы");
//        List<Film> filmsRepeated = List.of(shawshankRedemption, godfather, darkKnight, godfatherPartTwo, lordOfTheRingsTheReturnOfTheKing, godfather, forrestGump, leon, starWarsV, starWarsIV, leon, walle);
//        Cinema cinema2 = new Cinema();
//        System.out.println("Все фильмы были помещены в кинотеатр (true/false): " + cinema2.addListOfFilms(filmsRepeated));
//        System.out.println(cinema2);
//
//        System.out.println("Проверка получения множества фильмов по заданному году");
//        int settledYear = 1994;
//        System.out.println("Фильмы, изданные в " + settledYear + " году: " + cinema.getFilmOfSettledByYear(settledYear));
//
//        System.out.println("Проверка получения множества фильмов по заданному месяцу");
//        MonthOfProduction settledMonth = MonthOfProduction.September;
//        System.out.println("Фильмы, изданные в месяце " + settledMonth + ": " + cinema.getFilmOfSettledByMonth(settledMonth));
////
//        System.out.println("Проверка получения множества фильмов по заданному году и заданному месяцу");
//        int settledYear2 = 1994;
//        MonthOfProduction settledMonth2 = MonthOfProduction.September;
//        System.out.println("Фильмы, изданные в " + settledYear2 + " году в месяце " + settledMonth2 + ": " + cinema.getFilmOfSettledByYearAndMonth(settledYear2, settledMonth2));
//
//        System.out.println("Проверка получения множества фильмов по заданному жанру");
//        Genre genre = Genre.Drama;
//        System.out.println("Фильмы жанра " + genre + " : " + cinema.getFilmOfSettledByGenre(genre));


        System.out.println("Проверка получения топа лучших фильмов");
        System.out.println("Топ фильмов: " + cinema.getTopTenFilmsByRating());
    }



}
