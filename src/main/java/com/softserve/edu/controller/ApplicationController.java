package com.softserve.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This is plain MVC controller.
 * Use this controller to render yours .jsp views.
 * Other controllers annotated as @RestControllers maintain RESTful API,
 * so that's why we recommend you to implement rendering .jsp methods below.
 */
@Controller
public class ApplicationController {

    @RequestMapping("/")
    public String welcome() {
        return "index";
    }
}
