package com.softserve.edu.controller;

import com.softserve.edu.entity.user.User;
import com.softserve.edu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/user/getrole", method = RequestMethod.GET)
    public String getUserRole(Principal principal) {
        String role = "GUEST";
        if (principal != null) {
            User user = userRepository.findOne(principal.getName());
            role = user == null ? "NO_SUCH_USER" : user.getRole();
        }
        return role;
    }

}
