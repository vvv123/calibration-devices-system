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

    @Autowired
    private ClientService clientService;

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

    @RequestMapping(value = "/client/add-application", method = RequestMethod.POST)
    public @ResponseBody
    String requestServ(@RequestBody ApplicationDTO applicationDTO) {
        clientService.transferApplicationDTO(applicationDTO);
        return "555";
    }
}
