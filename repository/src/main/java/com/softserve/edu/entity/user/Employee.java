package com.softserve.edu.entity.user;


import com.softserve.edu.entity.Organization;

public abstract class Employee extends User {

    private Organization organization;

    protected Employee() {}

    public Employee(String username, String password, Role role, Organization organization) {
        super(username, password, role);
        this.organization = organization;
    }


}
