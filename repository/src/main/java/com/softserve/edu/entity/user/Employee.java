package com.softserve.edu.entity.user;

import com.softserve.edu.entity.Organization;

import javax.persistence.*;

@MappedSuperclass
public abstract class Employee extends User {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    private Organization organization;

    protected Employee() {}

    /**
     * Required constructor for saving employee in database.
     * Employee cannot exists without these parameters.
     *
     * @param username     username
     * @param password     password
     * @param role         role (organization employee or admin)
     * @param organization its organization
     */
    public Employee(String username, String password, Role role, Organization organization) {
        super(username, password, role);
        this.organization = organization;
    }

    /**
     * Completes constructor above with optional values     *
     *
     * @param firstName first name
     * @param lastName  last name
     * @param email     email
     * @param phone     phone number
     */
    public Employee(String username, String password, Role role, Organization organization,
                    String firstName, String lastName, String email, String phone) {
        this(username, password, role, organization);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
