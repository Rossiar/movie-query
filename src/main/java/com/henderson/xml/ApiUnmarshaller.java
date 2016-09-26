package com.henderson.xml;

import javax.xml.bind.JAXB;
import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: ross
 * Date: 26/09/16
 */
public class ApiUnmarshaller {

    public Apis unmarshal(File from) {
        return JAXB.unmarshal(from, Apis.class);
    }
}
