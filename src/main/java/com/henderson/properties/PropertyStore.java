package com.henderson.properties;

/**
 * Created with IntelliJ IDEA.
 * User: ross
 * Date: 26/09/16
 */
public interface PropertyStore {

    /**
     * Retrieves the value of a stored property as a String, or null if no property was found.
     *
     * @param key the reference to the property
     * @return the value of the property
     */
    String getProperty(String key);
}
