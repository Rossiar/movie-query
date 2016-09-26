package com.henderson.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ross
 * Date: 26/09/16
 */
@XmlRootElement(name = "arguments")
@XmlAccessorType(XmlAccessType.FIELD)
public class Arguments {

    @XmlElement(name = "argument")
    private List<Argument> arguments;

    public Map<String, String> getArguments() {
        Map<String, String> args = new HashMap<>();
        for (Argument arg : arguments) {
            args.put(arg.getKey(), arg.getValue());
        }
        return args;
    }
}
