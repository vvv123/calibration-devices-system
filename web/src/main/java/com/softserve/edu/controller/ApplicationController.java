package com.softserve.edu.controller;

import com.softserve.edu.dto.ApplicationDTO;
import com.softserve.edu.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(name = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

}
