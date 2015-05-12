package com.softserve.edu.controller;

import com.softserve.edu.service.SecurityUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class WelcomeController {

    @Autowired
    SecurityUserDetailsService securityUserDetailsService;

    /**
     * Responds details about current principal.
     *
     * @param principal - a user who made a request
     * @return "guest" if not authenticated or UserDetails for authenticated user.
     */
    @RequestMapping(value = "/getuser", method = RequestMethod.GET)
    public Object getUser(Principal principal) {
        return principal == null ? null : securityUserDetailsService.loadUserByUsername(principal.getName());
    }
}
