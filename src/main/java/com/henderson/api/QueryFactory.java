package com.henderson.api;

import com.henderson.xml.Api;

/**
 * Created with IntelliJ IDEA.
 * User: ross
 * Date: 27/09/16
 */
public class QueryFactory {

    public Query createQuery(Api api) {

        // TODO: Factory is messy and tightly coupled to naming
        switch (api.getName()) {
            case "OMDB":
                return new OmdbQuery(new MovieQueryable(), api);
            case "TMDB":
                return new TmdbQuery(new MovieQueryable(), api);
        }

        return null;
    }
}
