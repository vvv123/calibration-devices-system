package com.softserve.edu.controller;

import com.softserve.edu.entity.user.User;
import com.softserve.edu.repository.UserRepository;
import com.softserve.edu.security.SecurityUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    @Autowired
    SecurityUserDetailsService securityUserDetailsService;

    @RequestMapping(value = "/getuser", method = RequestMethod.GET)
    public Object getUser(Principal principal) {
        return principal == null ? null : securityUserDetailsService.loadUserByUsername(principal.getName());
    }

}
