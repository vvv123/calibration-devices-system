package com.softserve.edu.controller.client.application.util;

import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.HashMap;
import java.util.Map;

@PropertySource("classpath:/properties/mail.properties")
public class EmailSendingUtil {
    public static void setEmailSendingConfig(String firstName, String lastName, String clientCode, Environment env) {
        Map<String, Object> tempVars = new HashMap<>();
        tempVars.put("name", firstName + " " + lastName);
        tempVars.put("protocol", env.getProperty("site.protocol"));
        tempVars.put("domain", env.getProperty("site.domain"));
        tempVars.put("applicationId", clientCode);
    }
}
