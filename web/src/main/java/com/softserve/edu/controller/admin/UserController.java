package com.softserve.edu.controller.admin;

import com.softserve.edu.dto.PageDTO;
import com.softserve.edu.dto.admin.OrganizationPageItem;
import com.softserve.edu.entity.user.User;
import com.softserve.edu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/admin/users", method = RequestMethod.GET)
    public Iterable<User> getOrganizationsPage() {
        return userRepository.findAll();
    }

}
