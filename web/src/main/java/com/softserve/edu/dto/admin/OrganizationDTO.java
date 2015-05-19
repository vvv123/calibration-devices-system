package com.softserve.edu.dto.admin;

public class OrganizationDTO {
    private String name;
    private String email;
    private String phone;
    private String type;
    private String username;
    private String password;

    public OrganizationDTO() {
    }

    public OrganizationDTO(String name, String email, String phone, String type, String username, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.type = type;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
}
