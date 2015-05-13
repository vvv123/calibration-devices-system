package com.softserve.edu.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.softserve.edu.service.MailService;

@Controller
@RequestMapping("/mail")
public class TmpMailSendController {

	@Autowired
	private MailService mailService;

	@RequestMapping(value = "/send", method = RequestMethod.GET)
	public @ResponseBody Object getCalibrationTest(@RequestParam("to") String to,
			@RequestParam(value = "user", required = false, defaultValue = "Some User !") String user) {
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("name", user);
		mailService.sendMail(to, vars);
		return "okay";
	}

}