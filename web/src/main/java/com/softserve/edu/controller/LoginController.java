package com.softserve.edu.controller;


import com.softserve.edu.dto.LoginFormDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @RequestMapping(value = "/login/authorize", method = RequestMethod.POST)
    public LoginFormDTO authorize(@RequestBody LoginFormDTO loginFormDTO) {
        loginFormDTO.setUsername(loginFormDTO.getUsername() + " USERNAME");
        loginFormDTO.setPassword(loginFormDTO.getPassword() + " PASS");
        return loginFormDTO;
    }
}
