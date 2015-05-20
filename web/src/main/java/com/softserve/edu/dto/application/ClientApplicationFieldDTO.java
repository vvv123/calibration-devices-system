package com.softserve.edu.dto.application;

public class ClientApplicationFieldDTO {
    private Long id;
    private String designation;

    protected ClientApplicationFieldDTO() {}

    public ClientApplicationFieldDTO(Long id, String name) {
        this.id = id;
        this.designation = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
