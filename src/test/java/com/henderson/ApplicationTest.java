package com.henderson;

import com.henderson.properties.SystemPropertyStore;
import com.henderson.xml.Apis;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ross
 * Date: 26/09/16
 * <p/>
 * This test contains a lot of duplicated code, but I think this is good because unit tests are meant to be very
 * separate and very simple. I've often found that coupling tests together (a la JUnit 3) ends in a total mess that
 * is hard to maintain and add to.
 */
public class ApplicationTest {

    @Test
    public void businessAsUsual() {
        Map<String, String> args = new HashMap();
        args.put("api", "abc");
        args.put("movie", "def");
        new Application(new SystemPropertyStore(args), new Apis()).start();
    }

    @Test(expected = IllegalArgumentException.class)
    public void errorNoMovieFound() {
        Map<String, String> args = new HashMap();
        args.put("movie", "abc");
        new Application(new SystemPropertyStore(args), new Apis()).start();
    }
}
