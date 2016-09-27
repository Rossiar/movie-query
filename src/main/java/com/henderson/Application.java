package com.henderson;

import com.henderson.api.Query;
import com.henderson.api.QueryFactory;
import com.henderson.model.Movie;
import com.henderson.properties.PropertyStore;
import com.henderson.properties.SystemPropertyStore;
import com.henderson.xml.ApiUnmarshaller;
import com.henderson.xml.Apis;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: ross
 * Date: 26/09/16
 */
public class Application {

    /**
     * Used to acquire system properties
     */
    private PropertyStore properties;
    /**
     * The apis that can be accessed
     */
    private Apis apis;

    public static void main(String args[]) throws Exception {
        new Application(new SystemPropertyStore(),
                new ApiUnmarshaller().unmarshal(new File("apis.xml"))).start();
    }

    public Application(PropertyStore properties, Apis apis) {
        this.properties = properties;
        this.apis = apis;
    }

    public void start() {
        String queryString = this.properties.getProperty("movie");
        String apiName = this.properties.getProperty("api");

        Query query = new QueryFactory().createQuery(apis.findApi(apiName));
        for (Movie movie : query.movieQuery(queryString)) {
            System.out.println(movie.display());
        }
        System.out.println();
        System.out.println();
    }
}
