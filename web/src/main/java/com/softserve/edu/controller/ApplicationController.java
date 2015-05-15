package com.softserve.edu.controller;

import com.softserve.edu.dto.ApplicationDTO;
import com.softserve.edu.dto.ClientCodeDTO;
import com.softserve.edu.dto.ClientMessageDTO;
import com.softserve.edu.entity.Verification;
import com.softserve.edu.entity.util.Status;
import com.softserve.edu.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *
 * This is plain MVC controller.
 * Use this controller to render yours .jsp views.
 * Other controllers annotated as @RestControllers maintain RESTful API,
 * so that's why we recommend you to implement rendering .jsp methods below.
 *
 */
@RestController
public class ApplicationController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/application/add", method = RequestMethod.POST)
    public ClientCodeDTO getClientApplication(@RequestBody ApplicationDTO applicationDTO) {
      return clientService.transferApplication(applicationDTO);
    }
    @RequestMapping(value = "/application/check", method = RequestMethod.POST)
    public ClientMessageDTO getClientCode(@RequestBody ClientCodeDTO clientCodeDTO) {
        return  clientService.transferClientCode(clientCodeDTO);
    }
}
