package com.softserve.edu.dto;

import java.util.Map;

public class RegionDTO {
    private Long id;
    private String name;

    protected RegionDTO() {}

    public RegionDTO(Long id, String name) {
        ;
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }
}
