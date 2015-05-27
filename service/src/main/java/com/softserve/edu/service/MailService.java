package com.softserve.edu.service;

import org.apache.velocity.Template;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.ui.velocity.VelocityEngineUtils.mergeTemplateIntoString;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private VelocityEngine velocityEngine;

    @Value("${mail.credentials.username}")
    private String userName;

    @Value("${site.protocol}")
    private String protocol;

    @Value("${site.domain}")
    private String domain;
    
    @Autowired
    private ApplicationContext context;

    public void sendMail(String to, String userName, String clientCode) {

        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setTo(to);
                message.setFrom(userName);
                
                Map<String, Object> templateVariables = new HashMap<>();
                templateVariables.put("name", userName);
                templateVariables.put("protocol", protocol);
                templateVariables.put("domain", domain);
                templateVariables.put("applicationId", clientCode);

                String body = mergeTemplateIntoString(velocityEngine, "/velocityTemplates/mailTemplate.vm",
                        "UTF-8", templateVariables);
                message.setText(body, true);

            }
        };
        this.mailSender.send(preparator);
    }


}
