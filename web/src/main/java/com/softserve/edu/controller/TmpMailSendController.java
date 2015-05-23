package com.softserve.edu.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.softserve.edu.service.MailService;

@Controller
@RequestMapping("/mail")
@PropertySource("classpath:/properties/mail.properties")
public class TmpMailSendController {

	@Autowired
	private MailService mailService;
	
	@Autowired
    private Environment env;

	@RequestMapping(value = "/send", method = RequestMethod.GET)
	public @ResponseBody Object getCalibrationTest(@RequestParam("to") String to,
			@RequestParam(value = "user", required = false, defaultValue = "Some User !") String user) {
//		Map<String, Object> vars = new HashMap<String, Object>();
//		vars.put("name", user);
		Map<String, Object> tempVars = new HashMap<String, Object>();
        tempVars.put("name", "firstName lastName");
        tempVars.put("protocol", env.getProperty("site.protocol"));
        tempVars.put("domain", env.getProperty("site.domain"));
        tempVars.put("applicationId", "akwoert2389051-3oogd");
		mailService.sendMail(to, tempVars);
		return "okay";
	}

}