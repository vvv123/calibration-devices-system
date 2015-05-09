package com.softserve.edu.entity.user;

import com.softserve.edu.entity.Address;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "userType")
public abstract class User {
    @Id
    private String username;
    private String password;

    @Column(nullable = false)
    private String role;

    protected User() {}

    public User(String username, String password, Role role) {
        this.role = role.roleName();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
