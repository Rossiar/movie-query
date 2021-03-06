package com.henderson.api;

import com.henderson.model.Movie;
import com.henderson.xml.Api;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ross
 * Date: 27/09/16
 */
public class OmdbQuery implements Query {

    private Queryable queryable;
    private Api api;

    public OmdbQuery(Queryable queryable, Api api) {
        this.queryable = queryable;
        this.api = api;
    }

    /**
     * Search for a movie by title.
     *
     * @param title the title of the movie to search for
     * @return a list of movies that matched the title
     */
    public List<Movie> movieQuery(String title) {
        Map<String, String> args = this.api.getArguments();
        args.put("s", title);
        JSONObject parent = new JSONObject(this.queryable.query(this.api.getUrl(), args));
        JSONArray results = parent.getJSONArray("Search");
        List<Movie> movies = new ArrayList();

        // unfortunately cannot use a nice stream() here as JSONArray is not Iterable...
        for (int i = 0; i < results.length(); i++) {
            JSONObject result = results.getJSONObject(i);
            movies.add(new Movie(result.getString("Title"), result.getString("Year")));
        }

        return movies;
    }
}
