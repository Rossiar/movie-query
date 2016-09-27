package com.henderson.api;

import com.henderson.model.Movie;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ross
 * Date: 27/09/16
 */
public interface Query {

    List<Movie> movieQuery(String query);
}
