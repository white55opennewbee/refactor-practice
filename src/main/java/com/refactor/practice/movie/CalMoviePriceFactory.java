package com.refactor.practice.movie;

import com.refactor.practice.Movie;
import com.refactor.practice.Rental;

import java.util.HashMap;

public class CalMoviePriceFactory {
    private static final HashMap<Integer, CalPriceInterface> movieMap = new HashMap() {{
        put(Movie.REGULAR, new RegularMoviePrice());
        put(Movie.NEW_RELEASE, new NewReleaseMoviePrice());
        put(Movie.CHILDRENS, new ChildMoviePrice());
    }};

    public static double getMoviePrice(Rental rental) {
        return getCalPriceInterface(rental.getMovie()).calPrice(rental.getDayRented());
    }

    public static int getFrequentRenterPoints(Rental rental) {
        return getCalPriceInterface(rental.getMovie()).calFrequentRenterPoints(rental.getDayRented());
    }

    private static CalPriceInterface getCalPriceInterface(Movie movie) {
        return movieMap.get(movie.getPriceCode());
    }
}