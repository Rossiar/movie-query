package com.henderson.api;

import com.henderson.xml.Api;

/**
 * Created with IntelliJ IDEA.
 * User: ross
 * Date: 27/09/16
 *
 */
public class QueryFactory {

    /**
     * Create a new Query that can be used to find movies.
     *
     * @param api the API to query
     * @return a new Query object
     */
    public Query createQuery(Api api) {
        String name = api.getName();
        switch (name) {
            case "OMDB":
                return new OmdbQuery(new MovieQueryable(), api);
            case "TMDB":
                return new TmdbQuery(new MovieQueryable(), api);
            default:
                throw new IllegalArgumentException(String.format("No api %s exists", name));
        }
    }
}
