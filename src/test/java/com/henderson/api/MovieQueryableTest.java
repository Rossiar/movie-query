package com.henderson.api;

import org.json.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: ross
 * Date: 27/09/16
 */
public class MovieQueryableTest {

    @Test
    public void tmdbQuery() {
        MovieQueryable queryable = new MovieQueryable();
        Map<String, String> params = new HashMap();
        params.put("query", "Indiana Jones");
        params.put("language", "en_US");
        params.put("api_key", "8fd1151bba18fa28729823b415b7a40e");

        JSONObject json = new JSONObject(queryable.query("https://api.themoviedb.org/3/search/movie", params));
        assertThat(json.getJSONArray("results").length(), greaterThan(1));
    }


    @Test
    public void tmdbQueryNoAuth() {
        MovieQueryable queryable = new MovieQueryable();
        Map<String, String> params = new HashMap();
        params.put("query", "Indiana Jones");
        params.put("language", "en_US");

        JSONObject json = new JSONObject(queryable.query("https://api.themoviedb.org/3/search/movie", params));
        assertEquals("Invalid API key: You must be granted a valid key.", json.get("status_message"));
    }
}
