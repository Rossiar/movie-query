package com.henderson.properties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ross
 * Date: 26/09/16
 */
public class SystemPropertyStore implements PropertyStore {

    protected Map<String, String> properties;

    public SystemPropertyStore() {
        properties = new HashMap();
    }

    public SystemPropertyStore(Map<String, String> properties) {
        this.properties = properties;
    }

    public String getProperty(String key) {
        // check cache first
        String value = properties.get(key);

        // check in the System store
        if (value == null) {
            value = System.getProperty(key);
        }

        // not found
        if (value == null) {
            throw new IllegalArgumentException(String.format(
                    "No value for parameter %s, please supply the parameter with -D%s", key, key));
        }

        return value;
    }
}
