package com.henderson.properties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ross
 * Date: 26/09/16
 */
public class SystemPropertyStore implements PropertyStore {

    /**
     * The local cache (saves lookups to system all the time), also allows injection during testing
     */
    protected Map<String, String> cache;

    public SystemPropertyStore() {
        this.cache = new HashMap();
    }

    public SystemPropertyStore(Map<String, String> cache) {
        this.cache = cache;
    }

    /**
     * Checks a local cache, then the System cache for the given key/value pair,
     * if the value cannot be found, an {@link IllegalArgumentException} is thrown.
     *
     * @param key the reference to the property
     * @return the String value that is associated with this key.
     */
    public String getProperty(String key) {
        // check cache first
        String cacheValue = this.cache.get(key);
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
