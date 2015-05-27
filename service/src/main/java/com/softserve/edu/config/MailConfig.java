package com.softserve.edu.config;

import java.io.IOException;
import java.util.Properties;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;

@Configuration
@PropertySource("classpath:/properties/mail.properties")
@ComponentScan("com.softserve.edu.controller.service")
public class MailConfig {

	@Autowired
	private Environment env;

	@Bean
	public JavaMailSender mailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setDefaultEncoding("UTF-8");
		mailSender.setHost(env.getProperty("mail.config.host"));
		mailSender.setPort(env.getProperty("mail.config.port", Integer.class, 25));
		mailSender.setProtocol(env.getProperty("mail.config.protocol"));
		mailSender.setUsername(env.getProperty("mail.credentials.username"));
		mailSender.setPassword(env.getProperty("mail.credentials.password"));
		Properties properties = new Properties();
		properties.put("mail.smtp.aut", env.getProperty("mail.config.smtp.auth", Boolean.class, false));
		properties.put("mail.smtp.starttls.enable", env.getProperty("mail.config.smtp.starttls.enable", Boolean.class, false));
		properties.put("mail.smtp.socketFactory.fallback", "true");
		mailSender.setJavaMailProperties(properties);
		return mailSender;
	}
	
	@Bean
	public VelocityEngine velocityEngine() throws VelocityException, IOException{
		VelocityEngineFactoryBean factory = new VelocityEngineFactoryBean();
		factory.setResourceLoaderPath(env.getProperty("velocity.resource.loader.path"));
		factory.setPreferFileSystemAccess(env.getProperty("velocity.prefer.file.systema.access", Boolean.class, false));
		Properties props = new Properties();
		props.put("resource.loader", "class");
		props.put("class.resource.loader.class", env.getProperty("velocity.resource.loader.class"));
		factory.setVelocityProperties(props);
		return factory.createVelocityEngine();
	}

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigIn() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}