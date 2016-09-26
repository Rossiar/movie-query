package com.henderson.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with IntelliJ IDEA.
 * User: ross
 * Date: 26/09/16
 */
@XmlRootElement(name = "argument")
@XmlAccessorType(XmlAccessType.FIELD)
public class Argument {

    @XmlElement
    private String key;

    @XmlElement
    private String value;

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
