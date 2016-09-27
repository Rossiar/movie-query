package com.henderson;

import com.henderson.properties.SystemPropertyStore;
import com.henderson.xml.ApiUnmarshaller;
import com.henderson.xml.Apis;
import org.junit.Test;

import java.io.File;
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
    public void omdbQuery() {
        Map<String, String> args = new HashMap();
        args.put("api", "OMDB");
        args.put("movie", "Indiana Jones");
        new Application(new SystemPropertyStore(args),
                new ApiUnmarshaller().unmarshal(new File("src/test/resources/actual.xml"))).start();
    }

    @Test(expected = IllegalArgumentException.class)
    public void errorNoMovieFound() {
        Map<String, String> args = new HashMap();
        args.put("movie", "abc");
        new Application(new SystemPropertyStore(args), new Apis()).start();
    }
}
