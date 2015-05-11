package com.softserve.edu.controller;


import com.softserve.edu.dto.LoginFormDTO;
import com.softserve.edu.entity.user.SystemAdmin;
import com.softserve.edu.security.SecurityUserDetailsService;
import com.softserve.edu.service.SystemAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class LoginController {

    @Autowired
    private SystemAdminService systemAdminService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public SystemAdmin initAdmin() {
        return systemAdminService.createAdmin();
    }

}
