package com.henderson.api;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ross
 * Date: 26/09/16
 */
public class MovieQueryable implements Queryable {

    /**
     * Sends a GET request to the given URL with the attached parameters.
     *
     * @param url        the URL of the website to query
     * @param parameters the query parameters that will go in the request
     * @return a string representing the result of the query
     */
    public String query(String url, Map parameters) {
        try {
            return Unirest.get(url)
                    .queryString(parameters)
                    .asString().getBody();
        } catch (UnirestException e) {
            throw new RuntimeException(String.format("Failed to query %s", url), e);
        }
    }
}
