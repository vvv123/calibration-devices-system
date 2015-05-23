package com.softserve.edu.dto.catalogue;

public class CatalogueDTO {
    private Long id;
    private String designation;

    protected CatalogueDTO() {}

    public CatalogueDTO(Long id, String name) {
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
