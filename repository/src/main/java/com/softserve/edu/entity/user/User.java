package com.softserve.edu.entity.user;

import javax.persistence.*;

/**
 * User class.
 * Each user with grant privileges to login the system extends this class.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "userType")
@Table(name = "`USER`")
public abstract class User {
    @Id
    private String username;
    private String password;

    @Column(nullable = false)
    private String role;

    protected User() {}

    /**
     * Required constructor for saving employee in database.
     * Employee cannot exists without these parameters.
     *
     * @param username username
     * @param password password
     * @param role     (look through implementations of Role interface in each User-extended class)
     */
    public User(String username, String password, Role role) {
        this.username = username;
        this.password = password;
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
