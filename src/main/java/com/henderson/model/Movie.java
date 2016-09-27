package com.henderson.model;

/**
 * Created with IntelliJ IDEA.
 * User: ross
 * Date: 26/09/16
 * <p/>
 * Represents the small piece of information that we are looking to capture, controls printing itself.
 */
public class Movie {

    private String title;
    private String releaseDate;

    public Movie(String title, String releaseDate) {
        this.title = title;
        this.releaseDate = releaseDate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("%s, released in %s", this.title, this.releaseDate);
    }
}
