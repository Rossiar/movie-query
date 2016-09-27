package com.henderson.xml;

import javax.xml.bind.JAXB;
import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: ross
 * Date: 26/09/16
 */
public class ApiUnmarshaller {

    /**
     * Wraps the static call to JAXB so that this can be unit tested properly.
     *
     * @param from the file to unmarshal {@link Apis} from
     * @return an Apis object, which is a wrapper class for a List of Apis
     */
    public Apis unmarshal(File from) {
        return JAXB.unmarshal(from, Apis.class);
    }
}
