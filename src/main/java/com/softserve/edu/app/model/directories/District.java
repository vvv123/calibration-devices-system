package com.softserve.edu.app.model.directories;

import javax.persistence.*;
import java.util.Set;

@Entity
public class District {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;
    @OneToMany
    @JoinColumn(name = "locality_id")
    private Set<Locality> localities;

    protected District() {}

    public District(String name) {
        this.name = name;
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

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Set<Locality> getLocalities() {
        return localities;
    }

    public void setLocalities(Set<Locality> localities) {
        this.localities = localities;
    }

    @Override
    public String toString() {
        return name;
    }
}
