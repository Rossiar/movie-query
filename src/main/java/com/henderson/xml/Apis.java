package com.henderson.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ross
 * Date: 26/09/16
 */
@XmlRootElement(name = "apis")
@XmlAccessorType(XmlAccessType.FIELD)
public class Apis {

    @XmlElement(name = "api")
    private List<Api> apis;

    public List<Api> getApis() {
        return this.apis;
    }

    public Api findApi(String apiName) {
        for (Api api : this.getApis()) {
            if (apiName.equalsIgnoreCase(api.getName())) {
                return api;
            }
        }

        throw new RuntimeException(String.format("The api with name %s was not found", apiName));
    }
}
