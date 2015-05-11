package com.softserve.edu.service;

import com.softserve.edu.entity.user.SystemAdmin;
import com.softserve.edu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SystemAdminService {
    @Autowired
    private UserRepository userRepository;

    public SystemAdmin createAdmin() {
        String username = "admin";
        String password = new BCryptPasswordEncoder().encode("password");
        SystemAdmin systemAdmin = new SystemAdmin(username, password);
        userRepository.save(systemAdmin);
        return systemAdmin;
    }
}
