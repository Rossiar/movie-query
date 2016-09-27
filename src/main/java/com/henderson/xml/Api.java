package com.henderson.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ross
 * Date: 26/09/16
 */
@XmlRootElement(name = "api")
@XmlAccessorType(XmlAccessType.FIELD)
public class Api {

    @XmlElement
    private String name;

    @XmlElement
    private String url;

    @XmlElement
    private Arguments arguments;

    public String getUrl() {
        return this.url;
    }

    public String getName() {
        return this.name;
    }

    public Map<String, String> getArguments() {
        return this.arguments.getArguments();
    }

}
