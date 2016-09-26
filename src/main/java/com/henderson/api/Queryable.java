package com.henderson.api;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ross
 * Date: 26/09/16
 */
public interface Queryable {

    /**
     * Sends a get request to the given url with the given parameters
     *
     * @param url       the URL of the website to query
     * @param arguments the query arguments that will go in the request
     * @return the result of the GET request
     */
    String query(String url, Map arguments);
}
