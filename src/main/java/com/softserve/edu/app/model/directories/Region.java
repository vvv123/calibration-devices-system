package com.softserve.edu.app.model.directories;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Region {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    @OneToMany(mappedBy = "region")
    private Set<District> districts;

    protected Region() {}

    public Region(String name, Set<District> districts) {
        this.name = name;
        this.districts = districts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<District> getDistricts() {
        return districts;
    }

    public void setDistricts(Set<District> districts) {
        this.districts = districts;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", districts=" + districts +
                '}';
    }
}
