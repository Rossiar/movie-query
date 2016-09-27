package com.henderson.model;

/**
 * Created with IntelliJ IDEA.
 * User: ross
 * Date: 26/09/16
 */
public class Movie {

    private String title;
    private String releaseDate;

    public Movie(String title, String releaseDate) {
        this.title = title;
        this.releaseDate = releaseDate;
    }

    public String display() {
        return String.format("%s, released in %s", this.title, this.releaseDate);
    }
}
