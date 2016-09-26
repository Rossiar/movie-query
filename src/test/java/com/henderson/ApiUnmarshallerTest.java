package com.henderson;

import com.henderson.xml.Api;
import com.henderson.xml.ApiUnmarshaller;
import com.henderson.xml.Apis;
import org.junit.Test;

import java.io.File;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ross
 * Date: 26/09/16
 */
public class ApiUnmarshallerTest {

    @Test
    public void unmarshalOneApi() {
        ApiUnmarshaller marshaller = new ApiUnmarshaller();
        Apis parent = marshaller.unmarshal(new File("src/test/resources/test-api.xml"));
        Api testApi = parent.getApis().get(0);
        assertEquals("test", testApi.getName());
        assertEquals("https://test.com", testApi.getUrl());
        Map<String, String> args = testApi.getArguments();
        assertEquals("default", args.get("query"));
        assertEquals("en_US", args.get("language"));
        assertEquals("1234", args.get("api_key"));
    }


    @Test
    public void unmarshalManyApis() {
        ApiUnmarshaller marshaller = new ApiUnmarshaller();
        Apis apis = marshaller.unmarshal(new File("src/test/resources/many-apis.xml"));
        assertEquals(5, apis.getApis().size());
    }
}
