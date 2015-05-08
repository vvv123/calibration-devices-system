package com.softserve.edu.controller;

import com.softserve.edu.dto.LoginFormDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @RequestMapping(name = "/login/authenticate", method = RequestMethod.POST)
    public LoginFormDTO authenticate(LoginFormDTO loginFormDTO) {
        loginFormDTO.setUsername(loginFormDTO.getUsername() + " username");
        loginFormDTO.setPassword(loginFormDTO.getPassword() + " password");
        return loginFormDTO;
    }

}
