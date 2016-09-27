package com.henderson.api;

import com.henderson.model.Movie;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ross
 * Date: 27/09/16
 */
public interface Query {

    /**
     * Provides a list of movies that have the provided title in
     * their name.
     *
     * @param title the title of the movie to search for
     * @return zero to many Movies in a list, the List will never be <code>null</code>
     */
    List<Movie> movieQuery(String title);
}
