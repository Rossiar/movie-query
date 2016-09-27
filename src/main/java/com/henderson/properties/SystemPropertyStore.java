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
        String cacheValue = properties.get(key);
        // if not in the cache check the system store
        String value = cacheValue != null ? cacheValue : System.getProperty(key);

        // if not found at all
        if (value == null) {
            throw new IllegalArgumentException(String.format(
                    "No value for parameter %s, please supply the parameter with -D%s", key, key));
        }

        return value;
    }
}
