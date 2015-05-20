package com.softserve.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Router {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome() {
        return "/resources/app/welcome/index.html";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin() {
        return "/resources/app/admin/index.html";
    }

    @RequestMapping(value = "/provider", method = RequestMethod.GET)
    public String provider() {
        return "/resources/app/provider/index.html";
    }

    @RequestMapping(value = "/calibrator", method = RequestMethod.GET)
    public String calibrator() {
        return "/resources/app/calibrator/index.html";
    }

    @RequestMapping(value = "/verificator", method = RequestMethod.GET)
    public String verificator() {
        return "/resources/app/verificator/index.html";
    }

}
