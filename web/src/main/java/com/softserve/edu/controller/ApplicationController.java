package com.softserve.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * This is plain MVC controller.
 * Use this controller to render yours .jsp views.
 * Other controllers annotated as @RestControllers maintain RESTful API,
 * so that's why we recommend you to implement rendering .jsp methods below.
 *
 */
@Controller
public class ApplicationController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/client", method = RequestMethod.GET)
    public String client() {
        return "client";
    }

    @RequestMapping(value = "/provider", method = RequestMethod.GET)
    public String provider() {
        return "provider";
    }

    @RequestMapping(value = "/calibrator", method = RequestMethod.GET)
    public String calibrator() {
        return "calibrator";
    }

    @RequestMapping(value = "/verificator", method = RequestMethod.GET)
    public String verificator() {
        return "verificator";
    }

}
