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
